package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;

public class NewParcelInfoMapper extends AbstractMapper<NewParcelInfo, ParcelEntity> {
    @Override
    public ParcelEntity mapToTarget(NewParcelInfo object) {
        return ParcelEntity.builder()
                .trackingId(object.getTrackingId())
                .build();
    }

    @Override
    public NewParcelInfo mapToSource(ParcelEntity object) {
        return NewParcelInfo.builder()
                .trackingId(object.getTrackingId())
                .build();
    }
}
