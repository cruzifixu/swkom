package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcelEntityTest {
    ParcelEntity parcelEntity = new ParcelEntity();

    @Test
    void SetTrackingIdTest()
    {
        parcelEntity.setTrackingId("HGHH8G6OI");
        assertEquals("HGHH8G6OI", parcelEntity.getTrackingId());
    }

    @Test
    void SetWeightTest()
    {
        parcelEntity.setWeight(3.5f);
        assertEquals(3.5f, parcelEntity.getWeight());
        parcelEntity.setWeight(-1f);
        //assertThrows(ConstraintViolationException, parcelEntity);
    }

    /*
    @Test
    void SetId()
    {
        assertNotNull(parcelEntity);
        ParcelEntity parcelEntity2 = new ParcelEntity();
        assertNotEquals(parcelEntity.getId(), parcelEntity2.getId());
        assertNotNull(parcelEntity.getId());
        assertNotNull(parcelEntity2.getId());
    }
     */
    @Test
    void setRecipients()
    {
        RecipientEntity sender = new RecipientEntity();
        RecipientEntity recipient = new RecipientEntity();
        parcelEntity.setRecipient(recipient);
        parcelEntity.setSender(sender);
        assertNotNull(parcelEntity.getRecipient());
        assertNotNull(parcelEntity.getSender());
    }

    @Test
    void SetState()
    {
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);
        assertEquals(parcelEntity.getState(), TrackingInformation.StateEnum.PICKUP);
    }

    @Test
    void TestLists()
    {
        assertNull(parcelEntity.getVisitedHops());
        assertNull(parcelEntity.getFutureHops());
    }
}
