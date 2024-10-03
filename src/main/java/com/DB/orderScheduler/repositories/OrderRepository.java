package com.DB.orderScheduler.repositories;

import com.DB.orderScheduler.models.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<OrderModel, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.nombre LIKE %:filter%")
    List<OrderModel> search(@Param("filter") String filter);

    @Query(value = "SELECT u FROM User u WHERE u.nombre LIKE %:filter%")
    Page<OrderModel> search(@Param("filter") String filter, Pageable pageable);

    @Query(value = "SELECT u FROM User WHERE u.id = %:filter%")
    OrderModel searchById(@Param("filter") Long filter);
}
