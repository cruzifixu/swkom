package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T15:52:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

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

    @Override
    public NewParcelInfo toParcelInfoDto(ParcelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        return newParcelInfo;
    }
}
