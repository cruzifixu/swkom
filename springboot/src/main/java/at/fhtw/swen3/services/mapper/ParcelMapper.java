package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.persistence.entity.ParcelEntity;

public class ParcelMapper extends AbstractMapper<ParcelEntity, Parcel> {

    @Override
    public Parcel mapToTarget(ParcelEntity object){
        return Parcel.builder()
                .recipient(object.getRecipient())
                .build();
    }

    @Override
    public ParcelEntity mapToSource(Parcel object) {
        return ParcelEntity.builder()
                .recipient(object.getRecipient())
                .build();
    }
}
