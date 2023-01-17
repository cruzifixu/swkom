package UnitTests.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class HopArrivalMapperTest {
    @Test
    public void testEntityToDto() {
        // Create a HopArrivalEntity object
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("HJTH8G6OI");
        hopArrivalEntity.setDescription("Warehouse 50-1");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());

        // Convert the entity to a DTO
        HopArrival dto = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(hopArrivalEntity.getCode(), dto.getCode());
        assertEquals(hopArrivalEntity.getDescription(), dto.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), dto.getDateTime());
    }

    @Test
    public void testDtoToEntity() {
        // Create a HopArrival DTO
        HopArrival dto = new HopArrival();
        dto.setCode("HJTH8G6OI");
        dto.setDescription("Warehouse 50-1");
        dto.setDateTime(OffsetDateTime.now());

        // Convert the DTO to an entity
        HopArrivalEntity entity = HopArrivalMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getCode(), entity.getCode());
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getDateTime(), entity.getDateTime());
    }
}
