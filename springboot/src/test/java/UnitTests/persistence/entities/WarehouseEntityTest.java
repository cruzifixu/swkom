package UnitTests.persistence.entities;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WarehouseEntityTest {
    @Test
    public void SetLevel() {
        WarehouseEntity entity = new WarehouseEntity();
        entity.setLevel(5);
        assertThat(entity.getLevel()).isEqualTo(5);
    }

    @Test
    public void SetNextHops() {
        WarehouseEntity entity = new WarehouseEntity();
        List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
        nextHops.add(new WarehouseNextHopsEntity());
        entity.setNextHops(nextHops);
        assertThat(entity.getNextHops()).isEqualTo(nextHops);
    }
}
