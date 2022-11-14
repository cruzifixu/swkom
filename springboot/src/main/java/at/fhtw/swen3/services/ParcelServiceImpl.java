package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.Parcel;
import lombok.RequiredArgsConstructor;


public class ParcelServiceImpl extends ParcelService {
    /*
    public ParcelLogic(ParcelRepository repo)
    {
        return ;
    }

     */

    public ParcelServiceImpl(ParcelLogic parcelLogic) {
        super(parcelLogic);
    }

    public void submitnewParcle() {

    }
}
