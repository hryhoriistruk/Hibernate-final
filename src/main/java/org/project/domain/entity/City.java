package org.project.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "city", schema = "world")
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 35, columnDefinition = "varchar(35)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, foreignKey = @ForeignKey(name = "city_ibfk_1"))
    private Country country;

    @Column(name = "district", nullable = false, length = 20, columnDefinition = "varchar(20)")
    private String district;

    @Column(name = "population", nullable = false, columnDefinition = "int")
    private Integer population;
}
