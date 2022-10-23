package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ParcelMapper {

    @Mapping(source = "trackingInformation.state", target = "deliveryStatus")
    ParcelEntity from(Parcel parcel, NewParcelInfo newParcelInfo, TrackingInformation trackingInformation);

    Parcel toParcelDto(ParcelEntity entity);

    NewParcelInfo toParcelInfoDto(ParcelEntity entity);

    @Mapping(source = "entity.deliveryStatus", target = "state")
    TrackingInformation toTrackingInfoDto(ParcelEntity entity);

    /*@Override
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
    }*/
}
