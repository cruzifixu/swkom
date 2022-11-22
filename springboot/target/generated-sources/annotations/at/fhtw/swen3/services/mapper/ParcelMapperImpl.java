package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Parcel.ParcelBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T14:13:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity mapToTarget(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.weight( parcel.getWeight() );
        parcelEntity.recipient( parcel.getRecipient() );
        parcelEntity.sender( parcel.getSender() );
        parcelEntity.trackingId( parcel.getTrackingId() );

        return parcelEntity.build();
    }

    @Override
    public Parcel mapToSource(ParcelEntity parcelDTO) {
        if ( parcelDTO == null ) {
            return null;
        }

        ParcelBuilder parcel = Parcel.builder();

        parcel.weight( parcelDTO.getWeight() );
        parcel.recipient( parcelDTO.getRecipient() );
        parcel.sender( parcelDTO.getSender() );
        parcel.trackingId( parcelDTO.getTrackingId() );

        return parcel.build();
    }
}
