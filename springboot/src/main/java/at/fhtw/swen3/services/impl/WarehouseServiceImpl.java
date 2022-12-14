package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entity.HopEntity;
import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import at.fhtw.swen3.persistence.entity.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseRepository warehouseRepository;
    private WarehouseNextHopsRepository warehouseNextHopsRepository;
    private Validator validator;
    private WarehouseMapper warehouseMapper;

    @Override
    public Warehouse importWarehouses(Warehouse warehouse) throws Exception {
        validator.validate(warehouse);
        WarehouseEntity warehouseEntity = warehouseMapper.dtoToEntity(warehouse);
        WarehouseEntity createdWarehouseEntity = warehouseRepository.save(warehouseEntity);
        warehouseNextHopsRepository.saveAll(warehouseEntity.getNextHops());
        return warehouseMapper.entityToDto(createdWarehouseEntity);
    }

    @Override
    public List<Warehouse> exportWarehouses() {
        return null;
    }

    @Override
    public Hop getWarehouse(String code) throws SQLException {
        WarehouseEntity warehouseEntity = warehouseRepository.findByCode(code);
        if(warehouseEntity == null) return null;
        return warehouseMapper.entityToDto(warehouseEntity);
    }
}
