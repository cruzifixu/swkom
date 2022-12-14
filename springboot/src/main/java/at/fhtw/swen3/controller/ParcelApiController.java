package at.fhtw.swen3.controller;


import at.fhtw.swen3.controller.rest.ParcelApi;
import at.fhtw.swen3.services.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@RequiredArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-24T14:48:00.085786Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;
    private final ParcelService parcelService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
