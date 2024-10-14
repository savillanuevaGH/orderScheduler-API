package com.DB.orderScheduler.controllers;

import com.DB.orderScheduler.models.PlateModel;
import com.DB.orderScheduler.services.impl.PlateServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/plate")
public class PlateController extends BaseControllerImpl<PlateModel, PlateServiceImpl> {

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
    public ResponseEntity<?> searchById(@PathVariable Long filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchById(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/{category}")
    public ResponseEntity<?> findByCategory(@PathVariable Enum<?> filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findByCategory(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/{day}")
    public ResponseEntity<?> findByDay(@PathVariable LocalDate filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findByDay(filter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
