package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.services.WarehouseNextHopsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WarehouseNextHopsServiceImpl implements WarehouseNextHopsService {
    private WarehouseNextHopsRepository warehouseNextHopsRepository;
}
