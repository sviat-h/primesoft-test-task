package com.primesoft.service;

import com.primesoft.model.Vehicle;
import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllByUserLogin(String login);
}
