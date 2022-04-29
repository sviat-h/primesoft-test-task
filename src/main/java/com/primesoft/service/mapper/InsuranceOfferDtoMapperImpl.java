package com.primesoft.service.mapper;

import com.primesoft.lib.annotation.Service;
import com.primesoft.model.InsuranceOffer;
import com.primesoft.model.dto.InsuranceOfferDto;

@Service
public class InsuranceOfferDtoMapperImpl implements InsuranceOfferDtoMapper {
    @Override
    public InsuranceOfferDto mapToDto(InsuranceOffer insuranceOffer) {
        return InsuranceOfferDto.builder().id(insuranceOffer.getId())
                .insurer(insuranceOffer.getInsurer()).price(insuranceOffer.getPrice())
                .insertTime(insuranceOffer.getInsertTime()).build();
    }
}
