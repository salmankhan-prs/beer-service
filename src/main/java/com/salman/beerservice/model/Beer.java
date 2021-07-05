package com.salman.beerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "beer_id",
            nullable = false,
            unique = true
    )
    private String beerId;
    @Column(name = "beer_name",
    nullable = false,unique = true)
    private String beerName;
    private Double beerPrice;
    private Boolean isAvailable;
}
