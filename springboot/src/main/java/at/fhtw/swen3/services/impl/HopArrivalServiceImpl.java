package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.HopArrivalService;

import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import at.fhtw.swen3.services.HopArrivalService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HopArrivalServiceImpl implements HopArrivalService {
    private HopArrivalRepository hopArrivalRepository;
}
