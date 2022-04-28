package com.primesoft.dao;

import com.primesoft.model.Vehicle;
import java.util.List;

public interface VehicleDao {
    List<Vehicle> getAllByUserLogin(String login);
}
