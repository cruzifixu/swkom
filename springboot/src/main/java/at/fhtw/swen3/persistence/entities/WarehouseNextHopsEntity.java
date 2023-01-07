package at.fhtw.swen3.persistence.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouse_next_hop")
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Integer traveltimeMins;

    @ManyToOne
    @JoinColumn(name = "fk_warehouse")
    private HopEntity hop;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name = "warehouse_id")
    private HopEntity warehouse;
}
