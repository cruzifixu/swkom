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
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private WarehouseNextHopsRepository warehouseNextHopsRepository;
    @Autowired
    private HopRepository hopRepository;
    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;

    private WarehouseEntity setCorrectHopTypes(WarehouseEntity warehouse) {
        List<String> allowedTypes = new ArrayList<String>() {{
            add("hop");
            add("transferwarehouse");
            add("truck");
            add("warehouse");
        }};
        for (WarehouseNextHopsEntity nextHop : warehouse.getNextHops()) {
            String nextHopType = nextHop.getHop().getHopType();
            if (!allowedTypes.contains(nextHopType)) {
                nextHop.getHop().setHopType("hop");
            }
        }
        return warehouse;
    }

    @Override
    public void importWarehouses(Warehouse warehouse) throws Exception {
        WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);
        warehouseEntity = setCorrectHopTypes(warehouseEntity);
        try {
            for (WarehouseNextHopsEntity nextHop : warehouseEntity.getNextHops()) {
                GeoCoordinateEntity newGeoCoordinateEntity = geoCoordinateRepository.save(nextHop.getHop().getLocationCoordinates());
                nextHop.getHop().setLocationCoordinates(newGeoCoordinateEntity);
                HopEntity newHopEntity = hopRepository.save(nextHop.getHop());
                nextHop.setHop(newHopEntity);
                //nextHop.setWarehouse(warehouseEntity);
            }
            //GeoCoordinateEntity newGeoCoordinateEntity = geoCoordinateRepository.save(warehouseEntity.getLocationCoordinates());
            //warehouseEntity.setLocationCoordinates(newGeoCoordinateEntity);

            WarehouseEntity newWarehouseEntity = warehouseRepository.save(warehouseEntity);
        } catch (Exception e) {
            throw new Exception("Failed :( -> ", e);
        }
    }
}
