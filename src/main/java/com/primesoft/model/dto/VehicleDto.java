package com.primesoft.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class VehicleDto implements Serializable {
    private Long id;
    private String brand;
    private String model;
    private LocalDateTime insertTime;
    private List<InsuranceOfferDto> insuranceOffers;
}
