package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.persistence.entity.WarehouseNextHopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseNextHopRepository extends JpaRepository<WarehouseNextHopEntity, Long> {
}
