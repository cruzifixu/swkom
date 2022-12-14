package at.fhtw.swen3.persistence.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)    //for extending HopEntity
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "warehouse")
public class WarehouseEntity extends HopEntity{
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private Long id;*/

    @Column
    private Integer level;

    @Column
    //@OneToMany
    @OneToMany(mappedBy = "hop")
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}