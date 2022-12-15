package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;

import java.util.List;

public interface ParcelService {

    // returns trackingID
    void submitNewParcel(Parcel parcel); // Submit a new parcel to the logistics service.
    void transitionParcel(Parcel parcel, String trackingId); // Transfer an existing parcel into the system from the service of a logistics partner
    void reportDelivery(String trackingId); // Report that a Parcel has been delivered at it's final destination address
    List<HopArrivalEntity> trackParcel(String trackingId); // Find the latest state of a parcel by its tracking ID.
    void reportHop(String trackingId, String code);// "Report that a Parcel has arrived at a certain hop either Warehouse or Truck. ",

    List<Parcel> getAllParcels();

    void updateParcel(Long id, ParcelEntity parcelEntity);

    void deleteParcel(Long id);

    // util function
    String generateTrackingId();

}
