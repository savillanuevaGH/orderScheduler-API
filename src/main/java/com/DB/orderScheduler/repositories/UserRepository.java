package com.DB.orderScheduler.repositories;

import com.DB.orderScheduler.dto.UserDTO;
import com.DB.orderScheduler.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserModel, Long> {

    @Query(value = "SELECT u FROM user u WHERE u.email LIKE %:filter%")
    List<UserModel> search(@Param("filter") String filter);

    @Query(value = "SELECT u FROM user u WHERE u.nombre LIKE %:filter%")
    Page<UserModel> search(@Param("filter") String filter, Pageable pageable);

    @Query(value = "SELECT u FROM user u WHERE u.mail LIKE %:mail%")
    Optional<UserModel> findByEmail(@Param("mail") String email);

    @Query(value = "SELECT u FROM user WHERE u.id = %:filter%")
    UserModel searchById(@Param("filter") Long filter);

    @Query(value = "ADD %:usuario%")
    UserModel addUser(@Param("usuario")UserDTO userDTO);

    @Query(value = "DELETE u FROM user u WHERE u.email LIKE %:email_user%")
    UserModel deleteUser(@Param(value = "email_user") String userEmail);
}
