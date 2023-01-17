package UnitTests.persistence.entities;

import static org.assertj.core.api.Assertions.*;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.geolatte.geom.Geometry;
import org.junit.jupiter.api.Test;

public class TransferwarehouseEntityTest {

    @Test
    public void SetLogisticsPartner() {
        TransferwarehouseEntity entity = new TransferwarehouseEntity();
        entity.setLogisticsPartner("partner");
        assertThat(entity.getLogisticsPartner()).isEqualTo("partner");
    }

    @Test
    public void SetLogisticsPartnerUrl() {
        TransferwarehouseEntity entity = new TransferwarehouseEntity();
        entity.setLogisticsPartnerUrl("url");
        assertThat(entity.getLogisticsPartnerUrl()).isEqualTo("url");
    }
}

