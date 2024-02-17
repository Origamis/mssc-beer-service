package com.spring.andrius.msscbeerservice;

import com.spring.andrius.msscbeerservice.bootstrap.BeerLoader;
import com.spring.andrius.msscbeerservice.services.inventory.BeerInventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsscBeerServiceApplicationTests {

	@Autowired
	BeerInventoryService beerInventoryService;

	@Test
	void contextLoads() {
	}

	@Test
	void getOnHoldInventory() {
		Integer qoh = beerInventoryService.getOnHandInventory(BeerLoader.BEER_1_UUID);

		System.out.println(qoh);
	}
}
