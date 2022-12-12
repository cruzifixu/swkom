package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, Long> {
    @Override
    Optional<TruckEntity> findById(Long id);

    @Override
    List<TruckEntity> findAll();

    @Override
    <S extends TruckEntity> S save(S entity);

    @Override
    void deleteById(Long id);
}
