package com.primesoft.service.mapper;

import com.primesoft.lib.annotation.Inject;
import com.primesoft.lib.annotation.Service;
import com.primesoft.model.Vehicle;
import com.primesoft.model.dto.VehicleDto;
import java.util.stream.Collectors;

@Service
public class VehicleDtoMapperImpl implements VehicleDtoMapper {
    @Inject
    private InsuranceOfferDtoMapper insuranceOfferDtoMapper;

    @Override
    public VehicleDto mapToDto(Vehicle vehicle) {
        return VehicleDto.builder().id(vehicle.getId()).brand(vehicle.getBrand())
                .model(vehicle.getModel()).insertTime(vehicle.getInsertTime())
                .insuranceOffers(vehicle.getInsuranceOffers().stream()
                        .map(insuranceOfferDtoMapper::mapToDto).collect(Collectors.toList()))
                .build();
    }
}
