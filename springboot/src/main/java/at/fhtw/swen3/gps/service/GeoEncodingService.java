package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface GeoEncodingService {
    GeoCoordinateEntity encodeAddress(Address a);
    Geometry wktToGeometry(String Point);
}
