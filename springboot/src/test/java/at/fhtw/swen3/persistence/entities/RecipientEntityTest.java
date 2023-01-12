package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RecipientEntityTest {
    RecipientEntity recipientEntity = new RecipientEntity();

    @Test
    void SetSName()
    {
        assertNull(recipientEntity.getName());
        recipientEntity.setName("Fred");
        assertEquals("Fred", recipientEntity.getName());
    }

    @Test
    void SetStreet()
    {
        assertNull(recipientEntity.getStreet());
        recipientEntity.setStreet("Fred City Lane 23");
        assertEquals("Fred City Lane 23", recipientEntity.getStreet());
    }

    @Test
    void SetPostalCode()
    {
        assertNull(recipientEntity.getPostalCode());
        recipientEntity.setPostalCode("1020");
        assertEquals("1020", recipientEntity.getPostalCode());
    }

    @Test
    void SetCity()
    {
        assertNull(recipientEntity.getCity());
        recipientEntity.setCity("Vienna");
        assertEquals("Vienna", recipientEntity.getCity());
    }


    @Test
    void SetCountry()
    {
        assertNull(recipientEntity.getCountry());
        recipientEntity.setCountry("Austria");
        assertEquals("Austria", recipientEntity.getCountry());
    }


    @Test
    void SetLocationCoordinates()
    {
        GeoCoordinateEntity coordinates = new GeoCoordinateEntity();
        recipientEntity.setLocationCoordinates(coordinates);
        assertEquals(coordinates, recipientEntity.getLocationCoordinates());
    }




}
