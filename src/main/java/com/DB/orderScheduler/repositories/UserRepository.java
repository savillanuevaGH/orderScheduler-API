package com.DB.orderScheduler.repositories;

import com.DB.orderScheduler.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<UserModel, Long> {

    @Query(value = "SELECT u FROM user u WHERE u.email LIKE %:filter%")
    List<UserModel> search(@Param("filter") String filter);

    @Query(value = "SELECT u FROM user u WHERE u.nombre LIKE %:filter%")
    Page<UserModel> search(@Param("filter") String filter, Pageable pageable);

    @Query(value = "SELECT u FROM user WHERE u.id = %:filter%")
    UserModel searchById(@Param("filter") Long filter);

    @Query
    UserModel registerUser(@Param("usuario") UserModel userModel);
}
