package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse")
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    @Pattern(regexp = "\\A(.*?)\\s+(\\d+[a-zA-Z]{0,1}\\s{0,1}[/]{1}\\s{0,1}\\d*[a-zA-Z]{0,1}|\\d+[a-zA-Z-]{0,1}\\d*[a-zA-Z]{0,1})$")
    private Integer level;
    @Column
    private String code;

    @Column
    private String hopType;

    @Column
    private String locationName;
}
