package com.spring.andrius.msscbeerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.andrius.msscbeerservice.web.model.BeerDto;
import com.spring.andrius.msscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

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

        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJSON))
                .andExpect(status().isCreated());
    }

    @Test
    void givenBeer_whenUpdateBeer_expectStatusNoContent() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJSON))
                .andExpect(status().isNoContent());
    }

    private static BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("Corona")
                .beerStyle(BeerStyle.ALE)
                .price(new BigDecimal("1.34"))
                .upc(123456L)
                .build();
    }
}