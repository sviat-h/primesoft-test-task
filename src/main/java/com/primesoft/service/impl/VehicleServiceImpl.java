package com.primesoft.service.impl;

import com.primesoft.dao.VehicleDao;
import com.primesoft.lib.annotation.Inject;
import com.primesoft.lib.annotation.Service;
import com.primesoft.model.Vehicle;
import com.primesoft.service.VehicleService;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Inject
    private VehicleDao vehicleDao;

    @Override
    public List<Vehicle> getAllByUserLogin(String login) {
        return vehicleDao.getAllByUserLogin(login);
    }
}
