package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelLogic;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Component;

@Component
public class ParcelLogicImpl implements ParcelLogic {

    @Override
    public String getStorage(Parcel parcel)
    {
        return null;
    }
}
