package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.TrackingInformation;

public class TrackingInformationMapper extends AbstractMapper<TrackingInformation, ParcelEntity>
{
    @Override
    public ParcelEntity mapToTarget(TrackingInformation object) {
        return ParcelEntity.builder()
                .state(object.getState()).visitedHops(object.getVisitedHops()).futureHops(object.getFutureHops())
                .build();
    }

    @Override
    public TrackingInformation mapToSource(ParcelEntity object) {
        return TrackingInformation.builder()
                .state(object.getState()).visitedHops(object.getVisitedHops()).futureHops(object.getFutureHops())
                .build();
    }
}
