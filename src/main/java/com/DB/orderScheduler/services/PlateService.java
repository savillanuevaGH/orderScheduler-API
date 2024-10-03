package com.DB.orderScheduler.services;

import com.DB.orderScheduler.models.PlateModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlateService extends BaseService<PlateModel, Long> {

    List<PlateModel> search(String filter) throws Exception;

    Page<PlateModel> search(String filter, Pageable pageable) throws Exception;

    PlateModel searchById(Long filter) throws Exception;

    List<PlateModel> findByCategory(Enum<?> filter) throws Exception;
}
