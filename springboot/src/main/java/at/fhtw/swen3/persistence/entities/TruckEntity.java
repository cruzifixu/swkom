package at.fhtw.swen3.persistence.entities;

// import at.fhtw.swen3.services.dto.Hop; used in first version
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // no need for column with the Inheritancetype
@Getter
@Setter
@SuperBuilder
@Entity
public class TruckEntity extends HopEntity { // do not delete inheritance

    @Column
    // change all Strings of GeoCoordinate to a Geometry Object thing otherwise we get the postgres error with value too long
    private Geometry regionGeoJson;

    @Column
    private String numberPlate;
}
