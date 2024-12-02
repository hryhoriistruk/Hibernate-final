package org.project.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "country_language", schema = "world")
@Getter
@Setter
public class CountryLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,columnDefinition = "int")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, columnDefinition = "int", foreignKey = @ForeignKey(name = "country_language_ibfk_1"))
    private Country country;

    @Column(name = "language", nullable = false, length = 30, columnDefinition = "varchar(30)")
    private String language;

    @Column(name = "is_official", nullable = false, columnDefinition = "BIT")
    private Boolean isOfficial;

    @Column(name = "percentage", nullable = false, precision = 4, scale = 1,columnDefinition = "decimal(4,1)")
    private BigDecimal percentage;
}
