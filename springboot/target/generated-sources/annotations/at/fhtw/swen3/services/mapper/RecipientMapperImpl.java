package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.Recipient.RecipientBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T15:09:44+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public Recipient mapToTarget(RecipientEntity recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientBuilder recipient1 = Recipient.builder();

        recipient1.name( recipient.getName() );
        recipient1.street( recipient.getStreet() );
        recipient1.postalCode( recipient.getPostalCode() );
        recipient1.city( recipient.getCity() );
        recipient1.country( recipient.getCountry() );

        return recipient1.build();
    }

    @Override
    public RecipientEntity mapToSource(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.name( recipient.getName() );
        recipientEntity.street( recipient.getStreet() );
        recipientEntity.postalCode( recipient.getPostalCode() );
        recipientEntity.city( recipient.getCity() );
        recipientEntity.country( recipient.getCountry() );

        return recipientEntity.build();
    }
}
