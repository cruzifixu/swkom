package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import java.util.List;

public interface ParcelService {

    String submitNewParcel(Parcel parcel,String id);
    TrackingInformation getParcel(String tracking_id);
    void reportParcel(String tracking, String code);
    void reportDelivery(String tracking);

}
