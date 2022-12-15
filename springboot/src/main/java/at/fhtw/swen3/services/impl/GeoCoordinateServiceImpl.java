package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.services.GeoCoordinateService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeoCoordinateServiceImpl implements GeoCoordinateService {
    private GeoCoordinateRepository geoCoordinateRepository;
}
