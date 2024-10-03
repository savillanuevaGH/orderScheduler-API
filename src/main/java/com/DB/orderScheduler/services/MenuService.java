package com.DB.orderScheduler.services;

import com.DB.orderScheduler.models.MenuModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService extends BaseService<MenuModel, Long> {

    List<MenuModel> search(String filter) throws Exception;

    Page<MenuModel> search(String filter, Pageable pageable) throws Exception;

    MenuModel searchById(Long filter) throws Exception;
}
