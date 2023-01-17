package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "t_parcel")
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    @NotNull
    private String trackingId;
    @Column
    @Size(message = "weight must be over 0")
    @DecimalMin("0.0")
    private Float weight;

    @NotNull(message = "Recipient cannot be null")
    @ManyToOne
    @JoinColumn(name = "fk_recipient")
    private RecipientEntity recipient;
    @NotNull(message = "Sender cannot be null")
    @ManyToOne
    @JoinColumn(name = "fk_sender")
    private RecipientEntity sender;
    @Column
    private TrackingInformation.StateEnum state;

    @OneToMany
    private List<HopArrivalEntity> visitedHops;

    @OneToMany
    private List<HopArrivalEntity> futureHops;


    /*
    public int ValidVisitedHops(List<HopArrival> visitedHops)
    {
        for (HopArrival i : visitedHops)
        {
            if(!i.getCode().matches("[A-Z]{4}\\d{1,4}$")) return 3;
            if(!i.getDescription().matches("[A-Za-z]{3,}\\s[1-9]+[-|\\d]?\\d+")) return 4;
        }
        return 1;
    }

    public int ValidFutureHops(List<HopArrival> futureHops)
    {
        for (HopArrival i : futureHops)
        {
            if(!i.getCode().matches("[A-Z]{4}\\d{1,4}$")) return 3;
            if(!i.getDescription().matches("[A-Za-z]{3,}\\s[1-9]+[-|\\d]?\\d+")) return 4;
        }
        return 1;
    }

     */
}
