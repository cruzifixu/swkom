package UnitTests.persistence.entities;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WarehouseNextHopsEntityTest {
    @Test
    public void SetId() {
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        entity.setId(1L);
        assertThat(entity.getId()).isEqualTo(1L);
    }

    @Test
    public void SetTraveltimeMins() {
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        entity.setTraveltimeMins(60);
        assertThat(entity.getTraveltimeMins()).isEqualTo(60);
    }

    @Test
    public void SetHop() {
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        HopEntity hop = new HopEntity();
        entity.setHop(hop);
        assertThat(entity.getHop()).isEqualTo(hop);
    }
}
