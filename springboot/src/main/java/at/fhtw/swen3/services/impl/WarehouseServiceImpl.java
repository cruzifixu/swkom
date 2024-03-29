package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapperImpl;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private final WarehouseRepository warehouseRepository;

    @Autowired
    private final TruckRepository truckRepository;

    @Autowired
    private final TransferwarehouseRepository transferwarehouseRepository;

    @Autowired
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;

    @Autowired
    private final GeoCoordinateRepository geoCoordinateRepository;

    @Override
    public void importWarehouses(Warehouse warehouse) throws Exception {
        warehouseRepository.deleteAll();
        transferwarehouseRepository.deleteAll();
        truckRepository.deleteAll();

        WarehouseMapperImpl warehouseMapper = new WarehouseMapperImpl();

        WarehouseEntity warehouseEntity = warehouseMapper.dtoToEntity(warehouse);

        try {
            saveAllHops(warehouseEntity.getNextHops());
            geoCoordinateRepository.save(warehouseEntity.getLocationCoordinates());
            warehouseRepository.save(warehouseEntity);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Warehouse exportWarehouses() {
        WarehouseEntity warehouseEntity = warehouseRepository.findByLevel(0);
        WarehouseMapperImpl warehouseMapper = new WarehouseMapperImpl();
        return warehouseMapper.entityToDto(warehouseEntity);
    }

    @Override
    public Warehouse getWarehouse(String code) throws SQLException {
        WarehouseEntity warehouseEntity = warehouseRepository.findByCode(code);
        WarehouseMapperImpl warehouseMapper = new WarehouseMapperImpl();
        return warehouseMapper.entityToDto(warehouseEntity);
    }


    // helper function for savving all hops
    private void saveAllHops(List<WarehouseNextHopsEntity> warehouseNextHopsEntity) throws ParseException, org.locationtech.jts.io.ParseException {


        for (WarehouseNextHopsEntity warehouseNextHop: warehouseNextHopsEntity){
            switch (warehouseNextHop.getHop().getHopType()) {
                case "warehouse" -> {
                    warehouseNextHop.getHop().getLocationCoordinates().setPoint(new WKTReader().read("POINT (" + warehouseNextHop.getHop().getLocationCoordinates().getLon() + " " + warehouseNextHop.getHop().getLocationCoordinates().getLat() + ")"));
                    geoCoordinateRepository.save(warehouseNextHop.getHop().getLocationCoordinates());
                    saveAllHops(((WarehouseEntity) warehouseNextHop.getHop()).getNextHops());
                }
                case "truck" -> {
                    warehouseNextHop.getHop().getLocationCoordinates().setPoint(new WKTReader().read("POINT (" + warehouseNextHop.getHop().getLocationCoordinates().getLon() + " " + warehouseNextHop.getHop().getLocationCoordinates().getLat() + ")"));
                    geoCoordinateRepository.save(warehouseNextHop.getHop().getLocationCoordinates());
                    truckRepository.save((TruckEntity) warehouseNextHop.getHop());
                }
                case "transferwarehouse" -> {
                    warehouseNextHop.getHop().getLocationCoordinates().setPoint(new WKTReader().read("POINT (" + warehouseNextHop.getHop().getLocationCoordinates().getLon() + " " + warehouseNextHop.getHop().getLocationCoordinates().getLat() + ")"));
                    geoCoordinateRepository.save(warehouseNextHop.getHop().getLocationCoordinates());
                    transferwarehouseRepository.save((TransferwarehouseEntity) warehouseNextHop.getHop());
                }
            }
            warehouseNextHopsRepository.save(warehouseNextHop);

        }

    }
}
