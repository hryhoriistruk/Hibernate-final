package org.project.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.project.domain.enums.Continent;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "country", schema = "world")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "int")
    private Integer id;

    @Column(name = "code", nullable = false, length = 3, columnDefinition = "varchar(3)")
    private String code;

    @Column(name = "code_2", nullable = false, length = 2, columnDefinition = "varchar(2)")
    private String code_2;

    @Column(name = "name", nullable = false, length = 52, columnDefinition = "varchar(52)")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "continent", nullable = false, columnDefinition = "int")
    private Continent continent;

    @Column(name = "region", nullable = false, length = 26, columnDefinition = "varchar(26)")
    private String region;

    @Column(name = "surface_area", nullable = false, precision = 10, scale = 2, columnDefinition = "decimal(10,2)")
    private BigDecimal surface_area;

    @Column(name = "indep_year", columnDefinition = "smallint")
    private Short indep_year;

    @Column(name = "population", nullable = false, columnDefinition = "int")
    private Integer population;

    @Column(name = "life_expectancy", precision = 3, scale = 1, columnDefinition = "decimal(3,1)")
    private BigDecimal life_expectancy;

    @Column(name = "gnp", precision = 10, scale = 2, columnDefinition = "gnp(10,2)")
    private BigDecimal gnp;

    @Column(name = "gnpo_id", precision = 10, scale = 2, columnDefinition = "decimal(10,2)")
    private BigDecimal gnpo_id;

    @Column(name = "local_name", nullable = false, length = 45, columnDefinition = "varchar(45)")
    private String local_name;

    @Column(name = "government_form", nullable = false, length = 45, columnDefinition = "varchar(45)")
    private String government_form;

    @Column(name = "head_of_state", nullable = false, length = 60, columnDefinition = "varchar(60)")
    private String head_of_state;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capital", foreignKey = @ForeignKey(name = "country_ibfk_1"))
    private City capital;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private Set<CountryLanguage> languages;
}
