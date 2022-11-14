package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.Parcel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParcelService {

    private final ParcelLogic parcelLogic;

    public String getStorage(Parcel parcel) {
        return parcelLogic.getStorage(parcel);
    }

}
