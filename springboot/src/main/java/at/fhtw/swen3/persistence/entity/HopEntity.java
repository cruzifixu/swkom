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

    @OneToOne
    @JoinColumn(name = "fk_location_coordinates")
    private GeoCoordinateEntity locationCoordinates;

    public HopEntity(String code, String hopType, String description, Integer processingDelayMins, String locationName, GeoCoordinateEntity locationCoordinates) {
        this.code = code;
        this.hopType = hopType;
        this.description = description;
        this.processingDelayMins = processingDelayMins;
        this.locationName = locationName;
        this.locationCoordinates = locationCoordinates;
    }
}
