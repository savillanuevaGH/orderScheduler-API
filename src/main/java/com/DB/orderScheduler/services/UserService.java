package com.DB.orderScheduler.services;

import com.DB.orderScheduler.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends BaseService<UserModel, Long> {

    List<UserModel> search(String filter) throws Exception;

    Page<UserModel> search(String filter, Pageable pageable) throws Exception;

    UserModel searchById(Long filter) throws Exception;

    UserModel registerUser(UserModel userModel) throws IllegalArgumentException;
}
