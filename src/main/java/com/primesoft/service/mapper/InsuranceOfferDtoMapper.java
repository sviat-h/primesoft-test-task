package com.primesoft.service.mapper;

import com.primesoft.model.InsuranceOffer;
import com.primesoft.model.dto.InsuranceOfferDto;

public interface InsuranceOfferDtoMapper {
    InsuranceOfferDto mapToDto(InsuranceOffer insuranceOffer);
}
