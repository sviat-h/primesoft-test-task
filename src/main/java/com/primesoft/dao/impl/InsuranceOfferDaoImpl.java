package com.primesoft.dao.impl;

import com.primesoft.dao.InsuranceOfferDao;
import com.primesoft.exception.DataProcessingException;
import com.primesoft.lib.annotation.Dao;
import com.primesoft.model.InsuranceOffer;
import com.primesoft.util.ConnectionUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Dao
public class InsuranceOfferDaoImpl implements InsuranceOfferDao {
    @Override
    public List<InsuranceOffer> getAllByVehicleId(Long vehicleId) {
        String getAllQuery = "SELECT * FROM insurance_offers "
                + "WHERE vehicle_id = ? "
                + "AND is_deleted = FALSE";
        List<InsuranceOffer> insuranceOffers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement = connection.prepareStatement(getAllQuery)) {
            getAllStatement.setLong(1, vehicleId);
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                insuranceOffers.add(getAllInsuranceOffers(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of insurance offers by "
                    + "vehicleId: " + vehicleId, e);
        }
        return insuranceOffers;
    }

    private InsuranceOffer getAllInsuranceOffers(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        Long vehicleId = resultSet.getObject("vehicle_id", Long.class);
        String insurer = resultSet.getString("insurer");
        BigDecimal price = resultSet.getObject("price", BigDecimal.class);
        LocalDateTime insertTime = resultSet.getTimestamp("insert_time").toLocalDateTime();
        return InsuranceOffer.builder().id(id).vehicleId(vehicleId).insurer(insurer).price(price)
                .insertTime(insertTime).build();
    }
}
