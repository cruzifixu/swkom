package at.fhtw.swen3.services.mapper;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import org.mapstruct.Mapper;
import at.fhtw.swen3.services.dto.Recipient;
import org.mapstruct.factory.Mappers;

// id, name, street, postal code, city country
@Mapper
public interface RecipientMapper {
    RecipientMapper INSTANCE = Mappers.getMapper(RecipientMapper.class);

    Recipient entityToDto(RecipientEntity recipientEntity);
    RecipientEntity dtoToEntity(Recipient recipient);
}
