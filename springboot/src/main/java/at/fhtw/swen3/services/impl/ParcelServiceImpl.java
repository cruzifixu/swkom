package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RequiredArgsConstructor
@Slf4j
@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;
    @Autowired
    private final ParcelMapper parcelMapper;
    @Autowired
    private final Validator validator;

    @Override
    public String generateTrackingId() {
        Pattern p = Pattern.compile("^[A-Z\\d]{9}$");
        Matcher m = p.matcher("");
        String randomString = m.group();
        return randomString;
    }

    @Override
    public String submitNewParcel(Parcel parcel) {
        // create unique tracking.ID ?
        // we generate unique tracking id with 10 chars
        // String trackingID = RandomStringUtils.random(10);
        String trackingID = generateTrackingId();

        validator.validate(parcel);

        NewParcelInfo newParcelInfo = NewParcelInfo.builder().build();
        TrackingInformation trackingInformation = TrackingInformation.builder().build();

        // set state to PICKUP
        trackingInformation.setState(TrackingInformation.StateEnum.PICKUP);


        ParcelEntity parcelEntity = parcelMapper.from(parcel, newParcelInfo, trackingInformation);
        // set unique trackingID
        parcelEntity.setTrackingId(trackingID);
        parcelEntity = parcelRepository.save(parcelEntity);
        log.info("New parcel submitted: " + parcelEntity.getTrackingId());

        return trackingID;
    }

    @Override
    public void transitionParcel(Parcel parcel) {
        log.info("Transit new parcel: " + parcel.getTrackingId());
        // validate the data
        validator.validate(parcel);
        // create to entity and then put into Repository
        ParcelEntity parcelEntity = parcelMapper.dtoToEntity(parcel);
        parcelRepository.save(parcelEntity);
        log.info("New parcel submitted: " + parcelEntity.getTrackingId());
    }

    @Override
    public void reportDelivery(String trackingId) {
        // first get the Parcel by trackingID from the Repository
        ParcelEntity parcelEntity = parcelRepository.getById(Long.valueOf(trackingId));
        // delete from Repo
        parcelRepository.deleteById(Long.valueOf(trackingId));
        // validate the data
        validator.validate(parcelEntity);
        // change state to delivered in the DB
        parcelEntity.setState(TrackingInformation.StateEnum.DELIVERED);
        // save to repo
        parcelRepository.save(parcelEntity);
        log.info("New parcel delivered: " + parcelEntity.getTrackingId());
    }

    @Override
    public List<HopArrival> trackParcel(String trackingId) {
        // first get the Parcel by trackingID from the Repository
        ParcelEntity parcelEntity = parcelRepository.getById(Long.valueOf(trackingId));
        // Predict or fetch future hops to final destination
        log.info("Future Hops: " + parcelEntity.getFutureHops());
        return parcelEntity.getFutureHops();
    }

    @Override
    public void reportHop(String trackingId, String code) {

    }


    @Override
    public List<Parcel> getAllParcels() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = this.parcelRepository.findAll();

        for(ParcelEntity parcelEntity : parcelEntities) {
            parcelDtos.add(ParcelMapper.INSTANCE.entityToParcelDto(parcelEntity));
        }

        log.info("Get all parcels");
        return parcelDtos;
    }


    @Override
    public void updateParcel(Long id, ParcelEntity parcelEntity) {
        this.parcelRepository.save(parcelEntity);

        log.info("Parcel with ID " + parcelEntity.getId() + " updated: " + parcelEntity);
    }


    @Override
    public void deleteParcel(Long id) {
        this.parcelRepository.deleteById(id);

        log.info("Parcel with ID " + id + " deleted");
    }
}
