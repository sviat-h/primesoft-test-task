package com.primesoft.dao.impl;

import com.primesoft.dao.VehicleDao;
import com.primesoft.exception.DataProcessingException;
import com.primesoft.lib.annotation.Dao;
import com.primesoft.lib.annotation.Inject;
import com.primesoft.model.Vehicle;
import com.primesoft.service.InsuranceOfferService;
import com.primesoft.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Dao
public class VehicleDaoImpl implements VehicleDao {
    @Inject
    private InsuranceOfferService insuranceOfferService;

    @Override
    public List<Vehicle> getAllByUserLogin(String login) {
        String getAllQuery = "SELECT * "
                + "FROM vehicles "
                + "WHERE user_login = ?";
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement = connection.prepareStatement(getAllQuery)) {
            getAllStatement.setString(1, login);
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(getAllVehicles(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of vehicles by user login: "
                    + login, e);
        }
        vehicles.forEach(
                v -> v.setInsuranceOffers(insuranceOfferService.getAllByVehicleId(v.getId())));
        return vehicles;
    }

    private Vehicle getAllVehicles(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String userLogin = resultSet.getString("user_login");
        String brand = resultSet.getString("brand");
        String model = resultSet.getString("model");
        LocalDateTime insertTime = resultSet.getTimestamp("insert_time").toLocalDateTime();
        return Vehicle.builder().id(id).userLogin(userLogin).brand(brand).model(model)
                .insertTime(insertTime).build();
    }
}
