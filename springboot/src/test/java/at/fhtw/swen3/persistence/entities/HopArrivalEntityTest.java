package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HopArrivalEntityTest {
    HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();

    @Test
    void SetCode()
    {
        hopArrivalEntity.setCode("GHSR2");
        assertEquals("GHSR2", hopArrivalEntity.getCode());
    }

    @Test
    void SetDescription()
    {
        hopArrivalEntity.setDescription("okay");
        assertEquals("okay", hopArrivalEntity.getDescription());
    }
}
