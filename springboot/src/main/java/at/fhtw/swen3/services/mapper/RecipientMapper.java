package at.fhtw.swen3.services.mapper;
import at.fhtw.swen3.services.dto.Recipient;

// id, name, street, postal code, city country

public class RecipientMapper extends AbstractMapper<Recipient, at.fhtw.swen3.persistence.entity.Recipient>{
    @Override
    public at.fhtw.swen3.persistence.entity.Recipient mapToTarget(Recipient object) {
        return at.fhtw.swen3.persistence.entity.Recipient.builder()
                .name(object.getName()).street(object.getStreet()).postalCode(object.getPostalCode()).city(object.getCity()).country(object.getCountry())
                .build();
    }

    @Override
    public Recipient mapToSource(at.fhtw.swen3.persistence.entity.Recipient object) {
        return Recipient.builder()
                .name(object.getName()).street(object.getStreet()).postalCode(object.getPostalCode()).city(object.getCity()).country(object.getCountry())
                .build();
    }
}
