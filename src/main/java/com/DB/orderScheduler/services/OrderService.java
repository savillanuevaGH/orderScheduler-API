package com.DB.orderScheduler.services;

import com.DB.orderScheduler.models.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService extends BaseService<OrderModel, Long> {

    List<OrderModel> search(String filter) throws Exception;

    Page<OrderModel> search(String filter, Pageable pageable) throws Exception;

    OrderModel searchById(Long filter) throws Exception;
}
