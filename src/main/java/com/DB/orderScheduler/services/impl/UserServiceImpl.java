package com.DB.orderScheduler.services.impl;

import com.DB.orderScheduler.models.UserModel;
import com.DB.orderScheduler.repositories.UserRepository;
import com.DB.orderScheduler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserModel, Long> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> search(String filter) throws Exception {
        try {
            List<UserModel> usersSearch = userRepository.search(filter);
            return usersSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UserModel> search(String filter, Pageable pageable) throws Exception {
        try {
            Page<UserModel> usersSearch = userRepository.search(filter, pageable);
            return usersSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public UserModel searchById(Long filter) throws Exception {
        try {
            UserModel userSearched = userRepository.searchById(filter);
            return userSearched;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public UserModel registerUser(UserModel userModel) throws IllegalArgumentException {
        if (userRepository.existsById(userModel.getId())){
            throw new IllegalArgumentException("El email ya está registrado.");
        }
        return userRepository.save(userModel);
    }
}
