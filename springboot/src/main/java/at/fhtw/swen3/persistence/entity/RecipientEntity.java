package at.fhtw.swen3.persistence.entity;

import lombok.*;
import org.hibernate.internal.build.AllowPrintStacktrace;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RecipientEntity {
    @Id
    @GeneratedValue
    private Long id;


    @Column
    private String name;
    @Column
    private String street;
    @Column
    private String postalCode;
    @Column
    private String city;
    @Column
    private String country;

    public String ValidRecipient()
    {

        return null;
    }

    public int ValidPostal()
    {
        if (postalCode == null || postalCode.equals("")) return 0;
        if (postalCode.matches("[a|A]-\\d{4}")) return 1; // [a|A][-][0-9]{4}
        return 2; // other country - not austria
    }

    public int ValidStreet()
    {
        if(street == null || street.equals("")) return 0;
        if(street.matches("[a-zA-Z]+\\s\\d+([\\\\|a-z]\\d+[a-z]?)+")) return 1;
        return 2; // not valid address
    }
    public int ValidCityName()
    {

        return 2; // not valid
    }
}