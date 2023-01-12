package at.fhtw.swen3.persistence.entities;

import org.geolatte.geom.Geometry;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TruckEntityTest {
    TruckEntity truckEntity = new TruckEntity();

    @Test
    public void SetNumberPlate() {
        TruckEntity entity = new TruckEntity();
        entity.setNumberPlate("AB 123 CD");
        assertThat(entity.getNumberPlate()).isEqualTo("AB 123 CD");
    }
}
