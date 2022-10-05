package at.fhtw.swen3.services.mapper;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;

// id, name, street, postal code, city country

public class RecipientMapper extends AbstractMapper<Recipient, RecipientEntity>{
    @Override
    public RecipientEntity mapToTarget(Recipient object) {
        return RecipientEntity.builder()
                .name(object.getName()).street(object.getStreet()).postalCode(object.getPostalCode()).city(object.getCity()).country(object.getCountry())
                .build();
    }

    @Override
    public Recipient mapToSource(RecipientEntity object) {
        return Recipient.builder()
                .name(object.getName()).street(object.getStreet()).postalCode(object.getPostalCode()).city(object.getCity()).country(object.getCountry())
                .build();
    }
}
