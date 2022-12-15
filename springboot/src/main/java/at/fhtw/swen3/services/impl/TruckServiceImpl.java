package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.TruckRepository;
import at.fhtw.swen3.services.TruckService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {
    private TruckRepository truckRepository;
}
