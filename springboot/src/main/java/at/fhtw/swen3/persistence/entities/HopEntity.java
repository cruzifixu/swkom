package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hop")
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String hopType;

    @Column(name = "code")
    @Pattern(regexp = "^[A-Za-zÄÖÜäöüß0-9\\s\\-]+$")
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @Valid
    private GeoCoordinateEntity locationCoordinates;
}
