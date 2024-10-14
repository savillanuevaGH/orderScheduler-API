package com.DB.orderScheduler.services.impl;

import com.DB.orderScheduler.models.MenuModel;
import com.DB.orderScheduler.repositories.MenuRepository;
import com.DB.orderScheduler.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MenuServiceImpl extends BaseServiceImpl<MenuModel, Long> implements MenuService {

    @Autowired
    protected MenuRepository menuRepository;

    @Override
    public List<MenuModel> search(String filter) throws Exception {
        try {
            List<MenuModel> menuModelsSearch = menuRepository.search(filter);
            return menuModelsSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<MenuModel> search(String filter, Pageable pageable) throws Exception {
        try {
            Page<MenuModel> menusSearch = menuRepository.search(filter, pageable);
            return menusSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MenuModel searchById(Long filter) throws Exception {
        try {
            MenuModel menuSearched = menuRepository.searchById(filter);
            return menuSearched;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
