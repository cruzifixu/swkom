package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public interface HopRepository extends JpaRepository<HopEntity, Long> {
    @Override
    Optional<HopEntity> findById(Long id);

    @Override
    List<HopEntity> findAll();

    @Override
    <S extends HopEntity> S save(S entity);

    @Override
    void deleteById(Long id);

    HopEntity findByCode (String code) throws SQLException;
}
