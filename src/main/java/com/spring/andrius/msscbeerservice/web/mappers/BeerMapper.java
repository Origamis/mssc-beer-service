package com.spring.andrius.msscbeerservice.web.mappers;

import com.spring.andrius.msscbeerservice.domain.Beer;
import com.spring.andrius.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
