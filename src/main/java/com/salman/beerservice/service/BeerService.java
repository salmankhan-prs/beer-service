package com.salman.beerservice.service;

import com.salman.beerservice.model.Beer;

import java.util.List;

public interface BeerService {
    public Beer createBeer(Beer beer);
    List<Beer> findAllBear();
    Beer findById(String s);
    Beer findByBeerName(String s);
    List<Beer> findByIsAvailable();
    List<Beer>findByPrice(Double a);
    List<Beer>findByBeerPriceGreaterThanEqualAAndIsAvailableOrderById(Double d,Boolean b);
}
