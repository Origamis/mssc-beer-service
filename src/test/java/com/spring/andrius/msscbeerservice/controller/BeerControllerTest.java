package com.spring.andrius.msscbeerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.andrius.msscbeerservice.bootstrap.BeerLoader;
import com.spring.andrius.msscbeerservice.services.BeerService;
import com.spring.andrius.msscbeerservice.web.model.BeerDto;
import com.spring.andrius.msscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void givenBeerId_whenGetBeer_expectStatusIsOk() throws Exception {
        mockMvc.perform(
                get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void givenBeer_whenPostBeer_expectStatusIsCreated() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);

        when(beerService.saveNewBeer(beerDto)).thenReturn(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJSON))
                .andExpect(status().isCreated());
    }

    @Test
    void givenBeer_whenUpdateBeer_expectStatusNoContent() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);

        when(beerService.updateBeerById(any(), any())).thenReturn(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJSON))
                .andExpect(status().isNoContent());
    }

    private static BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("Corona")
                .beerStyle(BeerStyle.ALE)
                .price(new BigDecimal("1.34"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }
}