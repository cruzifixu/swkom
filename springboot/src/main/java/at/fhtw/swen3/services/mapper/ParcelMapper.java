package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.ParcelDto;
import at.fhtw.swen3.services.entity.ParcelEntity;

public class ParcelMapper extends AbstractMapper<ParcelEntity, ParcelDto> {

    @Override
    public ParcelDto mapToTarget(ParcelEntity object){
        return ParcelDto.builder()
                .recipient(object.getRecipient())
                .build();
    }

    @Override
    public ParcelEntity mapToSource(ParcelDto object) {
        return ParcelEntity.builder()
                .recipient(object.getRecipient())
                .build();
    }
}
