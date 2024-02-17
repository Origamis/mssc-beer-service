package com.spring.andrius.msscbeerservice.services;

import com.spring.andrius.msscbeerservice.web.model.BeerDto;
import com.spring.andrius.msscbeerservice.web.model.BeerPagedList;
import com.spring.andrius.msscbeerservice.web.model.BeerStyle;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyle beerStyle, PageRequest pageRequest);
}
