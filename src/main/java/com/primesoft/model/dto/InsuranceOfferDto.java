package com.primesoft.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class InsuranceOfferDto implements Serializable {
    private Long id;
    private String insurer;
    private BigDecimal price;
    private LocalDateTime insertTime;
}
