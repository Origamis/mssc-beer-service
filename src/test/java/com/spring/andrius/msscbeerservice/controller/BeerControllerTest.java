package com.spring.andrius.msscbeerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.andrius.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJSON))
                .andExpect(status().isCreated());
    }

    @Test
    void givenBeer_whenUpdateBeer_expectStatusNoContent() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJSON))
                .andExpect(status().isNoContent());
    }
}