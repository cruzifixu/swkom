package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelMapperTest {
    @Test
    public void testEntityToDto() {
        // Create a ParcelEntity object
        ParcelEntity entity = new ParcelEntity();
        entity.setWeight(2.0f);
        entity.setRecipient(new RecipientEntity());
        entity.setSender(new RecipientEntity());

        // Convert the entity to a DTO
        Parcel dto = ParcelMapper.INSTANCE.entityToParcelDto(entity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(entity.getWeight(), dto.getWeight());
        assertEquals(entity.getRecipient(), dto.getRecipient());
        assertEquals(entity.getSender(), dto.getSender());
    }

    @Test
    public void testDtoToEntity() {
        // Create a Parcel DTO
        Parcel dto = new Parcel();
        dto.setWeight(2.0f);
        dto.setRecipient(new RecipientEntity());
        dto.setSender(new RecipientEntity());

        // Convert the DTO to an entity
        ParcelEntity entity = ParcelMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getWeight(), entity.getWeight());
        assertEquals(dto.getRecipient(), entity.getRecipient());
        assertEquals(dto.getSender(), entity.getSender());
    }
}
