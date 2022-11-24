package at.fhtw.swen3.persistence.entity;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hop")
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String hopType;
    @Column
    @Pattern(regexp = "^[A-Za-zÄÖÜäöü0-9\\s\\-]+$")
    private String code;
    @Column
    private String description;
    @Column
    private Integer processingDelayMins;
    @Column
    private String locationName;
    @OneToOne
    private GeoCoordinateEntity locationCoordinates;
}
