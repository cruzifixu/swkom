package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Parcel.ParcelBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T12:54:26+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public Parcel entityToParcelDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelBuilder parcel1 = Parcel.builder();

        parcel1.weight( parcel.getWeight() );
        parcel1.recipient( parcel.getRecipient() );
        parcel1.sender( parcel.getSender() );
        parcel1.trackingId( parcel.getTrackingId() );

        return parcel1.build();
    }

    @Override
    public ParcelEntity dtoToEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.trackingId( parcel.getTrackingId() );
        parcelEntity.weight( parcel.getWeight() );
        parcelEntity.recipient( parcel.getRecipient() );
        parcelEntity.sender( parcel.getSender() );

        return parcelEntity.build();
    }
}
