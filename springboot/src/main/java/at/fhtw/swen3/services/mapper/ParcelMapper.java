package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;


public class ParcelMapper extends AbstractMapper<ParcelEntity, Parcel> {

    @Override
    public Parcel mapToTarget(ParcelEntity object){
        return Parcel.builder()
                .weight(object.getWeight()).recipient(object.getRecipient()).sender(object.getSender()).trackingId(object.getTrackingId())
                .build();
    }

    @Override
    public ParcelEntity mapToSource(Parcel object) {
        return ParcelEntity.builder()
                .weight(object.getWeight()).recipient(object.getRecipient()).sender(object.getSender()).trackingId(object.getTrackingId())
                .build();
    }
}
