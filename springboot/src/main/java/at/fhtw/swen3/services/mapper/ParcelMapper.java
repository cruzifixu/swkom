package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.repositories.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;

@Mapper
public interface ParcelMapper{
    ParcelEntity mapToTarget(Parcel parcel);
    Parcel mapToSource(ParcelEntity parcelDTO);
}
