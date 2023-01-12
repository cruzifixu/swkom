package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HopEntityTest {
    HopEntity hopEntity = new HopEntity();
    @Test
    void SetHopType()
    {
        hopEntity.setHopType("this type");
        assertEquals("this type", hopEntity.getHopType());
    }

    @Test
    void SetCode()
    {
        hopEntity.setCode("SjGH3");
        assertEquals("SjGH3", hopEntity.getCode());
    }

    @Test
    void SetDescription()
    {
        hopEntity.setDescription("Package will be arriving tomorrow");
        assertEquals("Package will be arriving tomorrow", hopEntity.getDescription());
    }

    @Test
    void SetProcessingDelayMins()
    {
        hopEntity.setProcessingDelayMins(10);
        assertEquals(10, hopEntity.getProcessingDelayMins());
    }

    @Test
    void SetLocationName()
    {
        hopEntity.setLocationName("Vienna");
        assertEquals("Vienna", hopEntity.getLocationName());
    }
}
