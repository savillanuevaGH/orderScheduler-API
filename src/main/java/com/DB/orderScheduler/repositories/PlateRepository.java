package com.DB.orderScheduler.repositories;

import com.DB.orderScheduler.models.PlateModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlateRepository extends BaseRepository<PlateModel, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.nombre LIKE %:filter%")
    List<PlateModel> search(@Param("filter") String filter);

    @Query(value = "SELECT u FROM User u WHERE u.nombre LIKE %:filter%")
    Page<PlateModel> search(@Param("filter") String filter, Pageable pageable);

    @Query(value = "SELECT u FROM User WHERE u.id = %:filter%")
    PlateModel searchById(@Param("filter") Long filter);

    @Query(value = "SELECT P FROM plate WHERE p.category LIKE %:filter%")
    List<PlateModel> findByCategory(@Param("filter") Enum<?> filter);
}
