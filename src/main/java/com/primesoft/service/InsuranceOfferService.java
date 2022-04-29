package com.primesoft.service;

import com.primesoft.model.InsuranceOffer;
import java.util.List;

public interface InsuranceOfferService {
    List<InsuranceOffer> getAllByVehicleId(Long id);
}
