package com.spring.andrius.msscbeerservice.bootstrap;

import com.spring.andrius.msscbeerservice.domain.Beer;
import com.spring.andrius.msscbeerservice.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(
                    Beer.builder()
                            .beerName("Corona")
                            .beerStyle("IPA")
                            .quantityToBrew(100)
                            .upc(33700L)
                            .price(new BigDecimal("1.37"))
                            .build()
            );

            beerRepository.save(
                    Beer.builder()
                            .beerName("Calsberg")
                            .beerStyle("API")
                            .quantityToBrew(200)
                            .upc(400L)
                            .price(new BigDecimal("2.99"))
                            .build()
            );
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
