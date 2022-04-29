package com.primesoft.service.mapper;

import com.primesoft.model.Vehicle;
import com.primesoft.model.dto.VehicleDto;

public interface VehicleDtoMapper {
    VehicleDto mapToDto(Vehicle vehicle);
}
