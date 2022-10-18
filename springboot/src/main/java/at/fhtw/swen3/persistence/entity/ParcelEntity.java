package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;
    @NotNull(message = "weight cannot be Null") @NotBlank(message = "weight cannot be blank")
    @Size(min = 0, message = "A valid weight must at least weigh 0.0")
    private Float weight;
    @NotNull(message = "Recipient cannot be Null")
    private transient Recipient recipient;
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

    public void ValidParcel()
    {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<ParcelEntity>> cV = validator.validate(this);

        for (ConstraintViolation<ParcelEntity> cv : cV) {
            System.out.println(String.format("Error here! property: [%s], value: [%s], message: [%s]", cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }
    }

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
