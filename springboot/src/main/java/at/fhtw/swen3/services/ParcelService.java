package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface ParcelService {

    // returns trackingID
    String submitNewParcel(Parcel parcel);

    List<Parcel> getAllParcels();

    void updateParcel(Long id, ParcelEntity parcelEntity);

    void deleteParcel(Long id);

}
