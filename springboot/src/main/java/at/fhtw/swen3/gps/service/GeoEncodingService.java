package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;

import java.io.IOException;

public interface GeoEncodingService {
    GeoCoordinateEntity encodeAddress(Address address) throws IOException, InterruptedException;
}
