package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T13:41:18+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public Recipient entityToDto(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        return recipient;
    }

    @Override
    public RecipientEntity dtoToEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntity recipientEntity = new RecipientEntity();

        return recipientEntity;
    }
}
