package com.spring.andrius.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {

    private UUID id;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String beerName;
    private BeerStyle beerStyle;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;
}
