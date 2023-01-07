package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParcelService {

    NewParcelInfo submitNewParcel(ParcelEntity parcelEntity);

    List<Parcel> getAllParcels();

    void updateParcel(Long id, ParcelEntity parcelEntity);

    void deleteParcel(Long id);

}
