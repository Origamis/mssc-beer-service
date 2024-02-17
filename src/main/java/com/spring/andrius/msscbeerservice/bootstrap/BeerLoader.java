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

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234200037";
    public static final String BEER_3_UPC = "0631234200038";

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
                            .upc(BEER_1_UPC)
                            .price(new BigDecimal("1.37"))
                            .build()
            );

            beerRepository.save(
                    Beer.builder()
                            .beerName("Calsberg")
                            .beerStyle("API")
                            .quantityToBrew(200)
                            .upc(BEER_2_UPC)
                            .price(new BigDecimal("2.99"))
                            .build()
            );

            beerRepository.save(
                    Beer.builder()
                            .beerName("Kalnapilis")
                            .beerStyle("PALE_ALE")
                            .quantityToBrew(2000)
                            .upc(BEER_3_UPC)
                            .price(new BigDecimal("3.99"))
                            .build()
            );
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
