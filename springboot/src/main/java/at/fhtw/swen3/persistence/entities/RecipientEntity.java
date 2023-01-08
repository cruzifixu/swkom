package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_recipient")
public class RecipientEntity {
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

    
    public void ValidRecipient()
    {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<RecipientEntity>> cV = validator.validate(this);

        for (ConstraintViolation<RecipientEntity> cv : cV) {
            System.out.println(String.format("Error here! property: [%s], value: [%s], message: [%s]", cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }
    }
}