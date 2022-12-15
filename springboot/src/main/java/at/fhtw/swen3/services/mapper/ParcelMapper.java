package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper{
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    //@Mapping(source = "trackingInformation.state", target = "state")
    //ParcelEntity from(Parcel parcel, NewParcelInfo newParcelInfo, TrackingInformation trackingInformation);
    Parcel entityToParcelDto(ParcelEntity parcel);
    ParcelEntity dtoToEntity(Parcel parcel);
}
