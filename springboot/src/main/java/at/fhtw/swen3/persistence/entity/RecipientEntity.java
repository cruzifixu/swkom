package at.fhtw.swen3.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

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
    @NotNull @NotBlank
    @Pattern(regexp = "\\b([A-Z][a-z]+[- ]?|[A-Z][- '][A-Z]?[a-z]+[- ]?|[a-z]{1,2}[ -'][A-Z][a-z]+)+", message = "Invalid name")
    private String name;
    @Column
    @NotNull @NotBlank
    @Pattern(regexp = "[a-zA-Z]+\\s\\d+([\\\\|a-z]\\d+[a-z]?)+", message = "Invalid Street name")
    private String street;
    @Column
    @NotNull @NotBlank
    @Pattern(regexp = "[a|A]-\\d{4}", message = "Invalid Postal Code")
    private String postalCode;
    @Column
    @NotNull @NotBlank
    @Pattern(regexp = "\\b([A-Z][a-z]+[- ]?|[A-Z][- '][A-Z]?[a-z]+[- ]?|[a-z]{1,2}[ -'][A-Z][a-z]+)+", message = "Invalid City")
    private String city;
    @Column
    private String country;

    
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