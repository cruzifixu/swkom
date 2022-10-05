package at.fhtw.swen3.persistence.entity;

import lombok.*;
import org.hibernate.internal.build.AllowPrintStacktrace;

import javax.persistence.*;

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
    private String name;
    @Column
    private String street;
    @Column
    private String postalCode;
    @Column
    private String city;
    @Column
    private String country;

}