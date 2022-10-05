package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private List<HopArrival> visitedHops;
    private List<HopArrival> futureHops;

    /*
    for error handling in future
    public String ValidParcel()
    {
           if()
           error
        return null;
    }

     */

    public int ValidParcelWeight()
    {
        if(weight >= 0.0) return 1;
        return 0;
    }

    public int ValidTrackingId()
    {
        if(trackingId.matches("^[A-Z\\d]{9}$")) return 1;
        return 0;
    }

    public int ValidRecipient()
    {
        if(recipient == null) return 0;
        return 1;
    }

    public int ValidVisitedHops()
    {
        if(visitedHops == null) return 0;
        for (HopArrival i : visitedHops)
        {
            if(!i.getCode().matches("[A-Z]{4}\\d{1,4}$")) return 3;
            if(!i.getDescription().matches("[A-Za-z]{3,}\\s[1-9]+[-|\\d]?\\d+")) return 4;
        }
        return 1;
    }

    public int ValidFutureHops()
    {
        if(futureHops == null) return 0;
        for (HopArrival i : futureHops)
        {
            if(!i.getCode().matches("[A-Z]{4}\\d{1,4}$")) return 3;
            if(!i.getDescription().matches("[A-Za-z]{3,}\\s[1-9]+[-|\\d]?\\d+")) return 4;
        }
        return 1;
    }
}
