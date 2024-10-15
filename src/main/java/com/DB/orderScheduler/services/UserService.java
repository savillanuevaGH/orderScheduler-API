package com.DB.orderScheduler.services;

import com.DB.orderScheduler.dto.UserDTO;
import com.DB.orderScheduler.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService extends BaseService<UserModel, Long> {

    List<UserModel> search(String filter) throws Exception;

    Page<UserModel> search(String filter, Pageable pageable) throws Exception;

    Optional<UserModel> findByEmail(String email) throws Exception;

    UserModel searchById(Long filter) throws Exception;

    UserModel addUser(UserDTO userDTO);

    UserDTO convertToDTO(UserModel userModel) throws Exception;

    UserModel deleteUser(UserModel userModel) throws Exception;
}
