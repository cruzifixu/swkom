package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.HttpRequest;
import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;


import java.io.IOException;
import java.util.Objects;

@Slf4j
public class OpenStreetMapsProxy implements GeoEncodingService {
    @Override
    public GeoCoordinateEntity encodeAddress(Address a) {

        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        try {
            JsonNode obj = Objects.requireNonNull(HttpRequest.getJsonnode(HttpRequest.getResponse(("https://nominatim.openstreetmap.org/?addressdetails=1&q=" + a.getStreet() + " " + a.getPostalCode() + " " + a.getCity() + " " + a.getCountry() + "&format=json&limit=1").replaceAll(" ", "%20")))).get(0);
            if (obj != null) {
                geoCoordinateEntity.setLat(Double.valueOf(obj.get("lat").textValue()));
                geoCoordinateEntity.setLon(Double.valueOf(obj.get("lon").textValue()));
                log.info("Geo coordinated have been found");
                geoCoordinateEntity.setPoint(wktToGeometry("POINT ("+geoCoordinateEntity.getLon()+" "+geoCoordinateEntity.getLat()+")"));
                return geoCoordinateEntity;
            }else{
                log.info("no geo coordinates found");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Geometry wktToGeometry(String point) {
        //TODO: exception handling


        try {
            return new WKTReader().read(point);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}