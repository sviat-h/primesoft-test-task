package com.primesoft.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    private Long id;
    private String userLogin;
    private String brand;
    private String model;
    private LocalDateTime insertTime;
    private List<InsuranceOffer> insuranceOffers;
}
