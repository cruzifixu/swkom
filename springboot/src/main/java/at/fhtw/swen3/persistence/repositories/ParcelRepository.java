package at.fhtw.swen3.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelRepository, Long> {
    List<ParcelRepository> findByTrackingId(String trackingId);
}
