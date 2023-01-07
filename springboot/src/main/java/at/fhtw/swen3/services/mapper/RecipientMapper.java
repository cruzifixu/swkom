package at.fhtw.swen3.services.mapper;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.mapstruct.Mapper;
import at.fhtw.swen3.services.dto.Recipient;

// id, name, street, postal code, city country
@Mapper
public interface RecipientMapper {
    Recipient entityToDto(RecipientEntity recipientEntity);
    RecipientEntity dtoToEntity(Recipient recipient);
}
