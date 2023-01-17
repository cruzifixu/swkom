package IntegrationTests;
import at.fhtw.swen3.OpenApiGeneratorApplication;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
@Category(Integration.class)
@SpringBootTest(classes = OpenApiGeneratorApplication.class)
class RestJUnitTest {

    @Autowired
    private MockMvc mockMvc;

    String workingDirectory = System.getProperty("user.dir");
    String track = "PYJRB4HZ6";

    @Order(1)
    @Test
    void submitParcel() throws Exception {
        String parcel = new String(Files.readAllBytes(Paths.get(workingDirectory +"/JsonData/Parcel.json")));
        MvcResult result=mockMvc.perform(post("/parcel/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parcel)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getContentAsString());
        track = root.get("trackingId").asText();
    }

    @Test
    void submitParcelFail() throws Exception {
        String parcel = new String(Files.readAllBytes(Paths.get(workingDirectory +"/JsonData/ParcelFail.json")));
        MvcResult result=mockMvc.perform(post("/parcel/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parcel)
                        .characterEncoding("utf-8"))
                .andExpect(status().is5xxServerError())
                .andReturn();
    }

    @Order(2)
    @Test
    void trackParcel() throws Exception {
        mockMvc.perform(get("/parcel/"+track))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void trackParcelFail() throws Exception {
        mockMvc.perform(get("/parcel"))
                .andExpect(status().isNotFound());
    }

    @Test
    void trackParcelBadreq() throws Exception {
        mockMvc.perform(get("/parcel/1"))
                .andExpect(status().is5xxServerError());
    }
    @Test
    void exportWarehousesFail() throws Exception {
        mockMvc.perform(get("/warehouse/"))
                .andExpect(status().isOk());
    }

    @Test
    void reportParcelDelivery() throws Exception {
        mockMvc.perform(post("/parcel/"+track+"/reportDelivery/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().is5xxServerError());
    }
    @Test
    void reportParcelDeliveryFail() throws Exception {
        mockMvc.perform(get("/parcel/"+track+"/reportDelivery/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isNotFound());
    }
    @Test
    void reportParcelDeliveryBadReq() throws Exception {
        mockMvc.perform(post("/parcel/"+""+"/report/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }
    @Order(3)
    @Test
    void transitionParcel() throws Exception {
        String parcel = new String(Files.readAllBytes(Paths.get(workingDirectory +"/JsonData/Parcel.json")));
        mockMvc.perform(post("/parcel/PYJRB4HS4/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parcel)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }


    @Test
    void reportparcelHopFail() throws Exception {
        mockMvc.perform(post("/parcel/"+track+"/reportHop/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isNotFound());
    }

}