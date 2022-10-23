package org.openapitools.business;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import org.junit.jupiter.api.Test;

public class ParcelEntityTest {

    private RecipientEntity recipient = new RecipientEntity();
    private ParcelEntity parcel = new ParcelEntity();

    @Test
    void ValidTrackingId()
    {
        parcel.setTrackingId("PYJRB4HZ6");
    }

    @Test
    void ValidRecipient()
    {

    }
}
