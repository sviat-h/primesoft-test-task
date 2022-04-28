package com.primesoft.dao;

import com.primesoft.model.InsuranceOffer;
import java.util.List;

public interface InsuranceOfferDao {
    List<InsuranceOffer> getAllByVehicleId(Long id);
}
