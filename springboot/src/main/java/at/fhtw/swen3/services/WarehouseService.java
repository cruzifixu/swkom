package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface WarehouseService {
    void importWarehouses(Warehouse warehouse) throws Exception;
    Warehouse exportWarehouses();
    Warehouse getWarehouse(String code) throws SQLException;
}
