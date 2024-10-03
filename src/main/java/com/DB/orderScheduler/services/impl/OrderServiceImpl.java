package com.DB.orderScheduler.services.impl;

import com.DB.orderScheduler.models.OrderModel;
import com.DB.orderScheduler.repositories.OrderRepository;
import com.DB.orderScheduler.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OrderServiceImpl extends BaseServiceImpl<OrderModel, Long> implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderModel> search(String filter) throws Exception {
        try {
            List<OrderModel> orderModelsSearch = orderRepository.search(filter);
            return orderModelsSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<OrderModel> search(String filter, Pageable pageable) throws Exception {
        try {
            Page<OrderModel> usersSearch = orderRepository.search(filter, pageable);
            return usersSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public OrderModel searchById(Long filter) throws Exception {
        try {
            OrderModel orderSearched = orderRepository.searchById(filter);
            return orderSearched;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
