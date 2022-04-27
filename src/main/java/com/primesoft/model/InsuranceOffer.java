package com.primesoft.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceOffer {
    private Long id;
    private Long vehicleId;
    private String insurer;
    private BigDecimal price;
    private LocalDateTime insertTime;
}
