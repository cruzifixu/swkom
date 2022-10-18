package at.fhtw.swen3.model.entities;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@Entity
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @NotNull(message = "weight cannot be Null") @NotBlank(message = "weight cannot be blank")
    @Size(min = 0, message = "A valid weight must at least weigh 0.0")
    private Float weight;


    @NotNull(message = "Recipient cannot be Null")
    private transient at.fhtw.swen3.services.dto.Recipient recipient;
    private transient Recipient sender;

    @NotNull(message = "Tracking ID cannot be Null") @NotBlank(message = "Tracking ID cannot be blank")
    @Pattern(regexp = "^[A-Z\\d]{9}$", message = "Invalid tracking ID")
    private String trackingId;
    private String value;
    private TrackingInformation.StateEnum state;

    @NotNull(message = "List cannot be Null")
    private transient List<@Valid HopArrival> visitedHops;

    @NotNull(message = "List cannot be Null")
    private transient List<@Valid HopArrival> futureHops;

}
