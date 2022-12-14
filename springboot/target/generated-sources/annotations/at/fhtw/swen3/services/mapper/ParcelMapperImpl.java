package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Parcel.ParcelBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T13:41:18+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public Parcel entityToParcelDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelBuilder parcel1 = Parcel.builder();

        return parcel1.build();
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
