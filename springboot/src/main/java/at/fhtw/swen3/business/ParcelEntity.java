package at.fhtw.swen3.business;

import at.fhtw.swen3.persistence.Recipient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @Entity

public class ParcelEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")

    @Column
    private Float weight;
    @Column
    private Recipient recipient;
    @Column
    private Recipient sender;
    @Column
    private String trackingId;
    @Column
    private String value;
}
