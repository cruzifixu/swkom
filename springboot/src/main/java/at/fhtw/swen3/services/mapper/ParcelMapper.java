package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;

@Mapper
public interface ParcelMapper{
    ParcelRepository mapToTarget(Parcel parcel);
    Parcel mapToSource(ParcelRepository parcelDTO);
}
