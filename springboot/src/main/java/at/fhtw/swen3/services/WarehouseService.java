package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Warehouse;
import org.springframework.stereotype.Service;

@Service
public interface WarehouseService {
    void importWarehouses(Warehouse warehouse) throws Exception;
}
