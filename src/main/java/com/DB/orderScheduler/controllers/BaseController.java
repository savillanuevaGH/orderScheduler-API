package com.DB.orderScheduler.controllers;

import com.DB.orderScheduler.models.BaseModel;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController <E extends BaseModel, ID extends Serializable> {

    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getById(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}
