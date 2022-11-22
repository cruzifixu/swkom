package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelLogic;
import at.fhtw.swen3.services.ParcelService;
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
