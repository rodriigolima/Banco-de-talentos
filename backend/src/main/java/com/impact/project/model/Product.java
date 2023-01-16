package com.impact.project.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "product")
public class Product extends RepresentationModel<Product> {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;
    
    @Column
    private String description;
    
    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "price_usd")
    private BigDecimal priceUSD;

    @Column(name = "price_eur")
    private BigDecimal priceEUR;
    
    public void updatePrices(BigDecimal priceUSD, BigDecimal priceEUR) {
        this.priceUSD = priceUSD;
        this.priceEUR = priceEUR;
    }
    
}
