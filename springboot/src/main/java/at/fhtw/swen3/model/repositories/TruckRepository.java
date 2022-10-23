package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, Long> {
}