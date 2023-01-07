package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Long> {
    @Override
    Optional<TransferwarehouseEntity> findById(Long id);

    @Override
    List<TransferwarehouseEntity> findAll();

    @Override
    <S extends TransferwarehouseEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
