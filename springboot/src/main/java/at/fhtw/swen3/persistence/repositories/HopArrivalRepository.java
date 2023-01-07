package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HopArrivalRepository extends JpaRepository<HopArrivalEntity, Long> {
    @Override
    Optional<HopArrivalEntity> findById(Long id);

    @Override
    List<HopArrivalEntity> findAll();

    @Override
    <S extends HopArrivalEntity> S save(S entity);

    @Override
    void deleteById(Long id);

}
