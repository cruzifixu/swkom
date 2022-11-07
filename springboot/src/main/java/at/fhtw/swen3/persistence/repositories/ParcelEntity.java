package at.fhtw.swen3.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelEntity extends JpaRepository<ParcelEntity, Long> {
    List<ParcelEntity> findByTrackingId(String trackingId);
}
