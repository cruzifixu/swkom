package at.fhtw.swen3.persistence.repositories;


import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {
    @NotNull
    @Override
    Optional<ParcelEntity> findById(@NotNull Long id);

    @NotNull
    @Override
    List<ParcelEntity> findAll();

    @NotNull
    @Override
    <S extends ParcelEntity> S save(@NotNull S entity);

    @Override
    void deleteById(@NotNull Long id);
}
