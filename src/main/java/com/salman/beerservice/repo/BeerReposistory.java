package com.salman.beerservice.repo;

import com.salman.beerservice.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerReposistory extends JpaRepository<Beer, Integer> {
    Beer findByBeerName(String name);
    Beer findByBeerId(String s);
    List<Beer> findByIsAvailable(Boolean b);
    List<Beer> findByBeerPriceGreaterThanEqual(Double a);
    List<Beer> findByBeerPriceGreaterThanEqualAndIsAvailableOrderById(Double d,Boolean b);
}
