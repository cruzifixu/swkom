package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-12T12:35:08+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, TrackingInformation trackingInformation, Parcel parcel) {
        if ( newParcelInfo == null && trackingInformation == null && parcel == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        return parcelEntity;
    }

    @Override
    public TrackingInformation entityToTrackingInformationDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        TrackingInformation trackingInformation = new TrackingInformation();

        return trackingInformation;
    }

    @Override
    public NewParcelInfo entityToNewParcelInfoDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        return newParcelInfo;
    }

    @Override
    public Parcel entityToParcelDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        Parcel parcel1 = new Parcel();

        return parcel1;
    }

    @Override
    public ParcelEntity dtoToEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        return parcelEntity;
    }
}
