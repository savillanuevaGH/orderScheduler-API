package com.DB.orderScheduler.repositories;

import com.DB.orderScheduler.models.BaseModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends BaseModel, ID extends Serializable> extends CrudRepository<E, ID> {
    ID findAll(Pageable pageable);
}