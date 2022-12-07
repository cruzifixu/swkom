package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;

    @Autowired
    private final RecipientRepository recipientRepository;

    @Override
    public void submitNewParcel(ParcelEntity parcelEntity) {
        recipientRepository.save(parcelEntity.getRecipient());
        recipientRepository.save(parcelEntity.getSender());
        parcelRepository.save(parcelEntity);
        log.info("New Parcel has been saved");
    }

    @Override
    public Collection<Parcel> getStorage() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = parcelRepository.findAll();
        ParcelMapperImpl parcelMapper = new ParcelMapperImpl();

        for(ParcelEntity parcelEntity : parcelEntities) {
            parcelDtos.add(parcelMapper.entityToDto(parcelEntity));
        }
        log.info("All ParcelDtos: {}", parcelDtos);
        return parcelDtos;
    }
}
