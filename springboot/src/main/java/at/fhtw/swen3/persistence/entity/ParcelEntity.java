package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;
    private Float weight;
    private Recipient recipient;
    private Recipient sender;
    private String trackingId;
    private String value;
    private TrackingInformation.StateEnum state;
}
