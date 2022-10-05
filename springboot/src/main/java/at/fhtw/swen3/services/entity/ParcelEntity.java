package at.fhtw.swen3.services.entity;

import at.fhtw.swen3.persistence.Recipient;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ParcelEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Float weight;
    private Recipient recipient;
    private Recipient sender;
    private String trackingId;
    private String value;
}
