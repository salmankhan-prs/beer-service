package com.salman.beerservice.Controller;

import com.salman.beerservice.model.Beer;
import com.salman.beerservice.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {
    @Autowired
    private BeerService beerService;
    @PostMapping("api/beer")
    //saving a new Beer
    public ResponseEntity<Beer> createBeer(@RequestBody Beer beer){
        beerService.createBeer(beer);
      return   ResponseEntity.status(HttpStatus.CREATED).body(beer);

    }
    //getting All Beer Details
    @GetMapping("/api/getAllBeers")
    public ResponseEntity<List<Beer>> getAllBeers(){
      List<Beer> beers=  beerService.findAllBear();
      return   ResponseEntity.status(HttpStatus.OK).body(beers);
    }
    //Getting Beer by Id
    @GetMapping("api/getBeerById/{id}")
    public ResponseEntity<Beer> getBeerById( @PathVariable String id){
       return ResponseEntity.status(HttpStatus.OK).body( beerService.findById(id));

    }
    //Getting Beer by name
    @GetMapping("api/BeerName/{name}")
    public ResponseEntity<Beer>findByBeerName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(beerService.findByBeerName(name));
    }
    //Getting Beer by Availbillty
    @GetMapping("api/Beer/Avail")
    public ResponseEntity<List<Beer>>findByIsAvailble(){
        return ResponseEntity.status(HttpStatus.OK).body(beerService.findByIsAvailable());
    }
    //Getting Beer by Price
    @GetMapping("api/price/{price}")
    public ResponseEntity<List<Beer>>findByprice(@PathVariable Double price){
        return ResponseEntity.status(HttpStatus.OK).body(beerService.findByPrice(price));
    }
//filtering Beers by price and availabilty
    @GetMapping("api/priceAndAvailable/{price}")
    public ResponseEntity<List<Beer>>findBypriceAndAvailbilty(@PathVariable Double price){
        return ResponseEntity.status(HttpStatus.OK).body(beerService.findByBeerPriceGreaterThanEqualAAndIsAvailableOrderById(price,Boolean.TRUE));//passing hard coded value for Avaialbilty As true

    }

}