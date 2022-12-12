package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface ParcelService {

    // returns trackingID
    String submitNewParcel(Parcel parcel); // Submit a new parcel to the logistics service.
    void transitionParcel(Parcel parcel); // Transfer an existing parcel into the system from the service of a logistics partner
    void reportDelivery(String trackingId); // Report that a Parcel has been delivered at it's final destination address
    List<HopArrival> trackParcel(String trackingId);

    List<Parcel> getAllParcels();

    void updateParcel(Long id, ParcelEntity parcelEntity);

    void deleteParcel(Long id);

}
