package com.salman.beerservice.service;

import com.salman.beerservice.model.Beer;
import com.salman.beerservice.repo.BeerReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
private BeerReposistory beerReposistory;
    @Override
    public Beer createBeer(Beer beer) {
        beer.setBeerId(UUID.randomUUID().toString());
       beerReposistory.save(beer);
       return beer;
    }

    @Override
    public List<Beer> findAllBear() {
     return   beerReposistory.findAll();
    }

    @Override
    public Beer findById(String s) {
       return beerReposistory.findByBeerId(s);
    }

    @Override
    public Beer findByBeerName(String s) {
     return beerReposistory.findByBeerName(s);

    }

    @Override
    public List<Beer> findByIsAvailable() {
        return beerReposistory.findByIsAvailable(false);
    }

    @Override
    public List<Beer> findByPrice(Double a) {
        return beerReposistory.findByBeerPriceGreaterThanEqual(a);
    }

    @Override
    public List<Beer> findByBeerPriceGreaterThanEqualAAndIsAvailableOrderById(Double d, Boolean b) {
       return beerReposistory.findByBeerPriceGreaterThanEqualAndIsAvailableOrderById(d,b);
    }
}
