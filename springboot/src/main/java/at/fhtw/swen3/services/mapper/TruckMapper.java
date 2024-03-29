package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = HopMapper.class)
public interface TruckMapper {
    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);

    @Mapping(target = "regionGeoJson",source = "regionGeoJson",qualifiedByName = "mapGeometryToString")
    Truck entityToDto(TruckEntity truckEntity);
    @Mapping(target = "regionGeoJson",source = "regionGeoJson",qualifiedByName = "mapStringToGeometry")
    TruckEntity dtoToEntity(Truck truck);

    @Named("mapStringToGeometry")
    default Geometry mapStringToGeometry(String geoJson) throws ParseException {
        JsonObject jsonObject = new JsonParser().parse(geoJson).getAsJsonObject();

        String geo = jsonObject.getAsJsonObject("geometry").toString();

        return new GeoJsonReader().read(geo);
    }

    @Named("mapGeometryToString")
    default String mapGeometryToString(Geometry geometry) {
        return new GeoJsonWriter().write(geometry);
    }

}
