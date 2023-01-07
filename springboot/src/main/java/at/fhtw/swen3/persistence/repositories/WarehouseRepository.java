package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {
    @Override
    Optional<WarehouseEntity> findById(Long id);

    @Override
    List<WarehouseEntity> findAll();

    @Override
    <S extends WarehouseEntity> S save(S entity);

    @Override
    void deleteById(Long id);

    WarehouseEntity findByCode(String code);
}
