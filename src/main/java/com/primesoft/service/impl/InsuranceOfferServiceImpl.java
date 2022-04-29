package com.primesoft.service.impl;

import com.primesoft.dao.InsuranceOfferDao;
import com.primesoft.lib.annotation.Inject;
import com.primesoft.lib.annotation.Service;
import com.primesoft.model.InsuranceOffer;
import com.primesoft.service.InsuranceOfferService;
import java.util.List;

@Service
public class InsuranceOfferServiceImpl implements InsuranceOfferService {
    @Inject
    private InsuranceOfferDao insuranceOfferDao;

    @Override
    public List<InsuranceOffer> getAllByVehicleId(Long id) {
        return insuranceOfferDao.getAllByVehicleId(id);
    }
}
