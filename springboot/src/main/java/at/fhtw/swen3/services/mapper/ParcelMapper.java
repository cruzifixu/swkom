package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper{
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, TrackingInformation trackingInformation, Parcel parcel);

    TrackingInformation entityToTrackingInformationDto(ParcelEntity parcel);
    NewParcelInfo entityToNewParcelInfoDto(ParcelEntity parcel);
    Parcel entityToParcelDto(ParcelEntity parcel);

    ParcelEntity dtoToEntity(Parcel parcel);
}
