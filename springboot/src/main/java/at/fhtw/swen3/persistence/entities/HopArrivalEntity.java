package at.fhtw.swen3.persistence.entities;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_hoparrival")
public class HopArrivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    @Pattern(regexp = " ^[A-Z]{4}\\d{1,4}$", message = "must match postal code regex")
    private String code;
    @Column
    private String description;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;
}
