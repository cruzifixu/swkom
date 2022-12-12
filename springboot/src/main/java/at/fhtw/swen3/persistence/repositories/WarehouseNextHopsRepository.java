package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entity.WarehouseNextHopsEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Long> {
    @Override
    Optional<WarehouseNextHopsEntity> findById(@NotNull Long id);

    @NotNull
    @Override
    List<WarehouseNextHopsEntity> findAll();

    @NotNull
    @Override
    <S extends WarehouseNextHopsEntity> S save(@NotNull S entity);

    @Override
    void deleteById(@NotNull Long id);
}
