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


    @Column @Pattern(regexp = "^[A-Z]+[a-zA-Z',.\\s-]")@NotNull(message = "Name cannot be null")
    private String name;

    @Column @Pattern(regexp = "\\A(.*?)\\s+(\\d+[a-zA-Z]{0,1}\\s{0,1}[/]{1}\\s{0,1}\\d*[a-zA-Z]{0,1}|\\d+[a-zA-Z-]{0,1}\\d*[a-zA-Z]{0,1})$")@NotNull(message = "Name cannot be null")
    private String street;

    @Column @Pattern(regexp = "^A-[0-9]{4}$") @NotNull(message = "Name cannot be null")
    private String postalCode;

    @Column @Pattern(regexp = "^[A-Z]+[a-zA-Z',.\\s-]")@NotNull(message = "Name cannot be null")
    private String city;

    @Column
    private String country;

    @OneToOne (cascade = CascadeType.REMOVE)
    private GeoCoordinateEntity locationCoordinates;
}