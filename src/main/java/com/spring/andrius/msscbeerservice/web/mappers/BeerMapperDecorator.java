package com.spring.andrius.msscbeerservice.web.mappers;

import com.spring.andrius.msscbeerservice.domain.Beer;
import com.spring.andrius.msscbeerservice.services.inventory.BeerInventoryService;
import com.spring.andrius.msscbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {

    @Autowired
    private BeerInventoryService beerInventoryService;

    @Autowired
    private BeerMapper beerMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        BeerDto dto = beerMapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnHandInventory(beer.getId()));

        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return beerMapper.beerDtoToBeer(beerDto);
    }
}
