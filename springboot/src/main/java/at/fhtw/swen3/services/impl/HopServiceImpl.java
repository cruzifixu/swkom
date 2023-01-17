package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.TransferwarehouseRepository;
import at.fhtw.swen3.persistence.repositories.TruckRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.HopService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.TransferwarehouseMapperImpl;
import at.fhtw.swen3.services.mapper.TruckMapperImpl;
import at.fhtw.swen3.services.mapper.WarehouseMapperImpl;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class HopServiceImpl implements HopService{
    private final TruckRepository truckRepository;
    private final WarehouseRepository warehouseRepository;
    private final TransferwarehouseRepository transferwarehouseRepository;
    @Override
    public Hop getHop(String code) throws SQLException {
        TruckMapperImpl truckMapper = new TruckMapperImpl();
        WarehouseMapperImpl warehouseMapper= new WarehouseMapperImpl();
        TransferwarehouseMapperImpl transferwarehouseMapper = new TransferwarehouseMapperImpl();
        HopEntity hop = truckRepository.findByCode(code);
        if (hop != null) {
            return truckMapper.entityToDto((TruckEntity) hop);
        }
        hop = warehouseRepository.findByCode(code);
        if (hop != null) {
            return warehouseMapper.entityToDto((WarehouseEntity) hop);
        }

        hop = transferwarehouseRepository.findByCode(code);
        return transferwarehouseMapper.entityToDto((TransferwarehouseEntity) hop);
    }
}
