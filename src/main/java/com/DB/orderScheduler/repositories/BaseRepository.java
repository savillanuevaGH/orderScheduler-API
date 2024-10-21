package com.DB.orderScheduler.repositories;

import com.DB.orderScheduler.models.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends BaseModel, ID extends Serializable> extends JpaRepository<E, ID> {
}