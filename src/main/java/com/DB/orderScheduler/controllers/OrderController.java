package com.DB.orderScheduler.controllers;

import com.DB.orderScheduler.models.OrderModel;
import com.DB.orderScheduler.services.impl.OrderServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/order")
public class OrderController extends BaseControllerImpl<OrderModel, OrderServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filter, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchById(@RequestParam @PathVariable Long filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchById(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
