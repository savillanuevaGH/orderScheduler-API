package com.DB.orderScheduler.services.impl;

import com.DB.orderScheduler.models.PlateModel;
import com.DB.orderScheduler.repositories.PlateRepository;
import com.DB.orderScheduler.services.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PlateServiceImpl extends BaseServiceImpl<PlateModel, Long> implements PlateService {

    @Autowired
    private PlateRepository plateRepository;

    @Override
    public List<PlateModel> search(String filter) throws Exception {
        try {
            return plateRepository.search(filter);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<PlateModel> search(String filter, Pageable pageable) throws Exception {
        try {
            return plateRepository.search(filter, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PlateModel searchById(Long filter) throws Exception {
        try {
            return plateRepository.searchById(filter);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<PlateModel> findByCategory(Enum<?> filter) throws Exception {
        try {
            return plateRepository.findByCategory(filter);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
