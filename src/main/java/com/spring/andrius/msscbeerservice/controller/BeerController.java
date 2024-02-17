package com.spring.andrius.msscbeerservice.controller;

import com.spring.andrius.msscbeerservice.services.BeerService;
import com.spring.andrius.msscbeerservice.web.model.BeerDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {

    private BeerService beerService;

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeerById(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}
