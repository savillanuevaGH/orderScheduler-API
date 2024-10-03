package com.DB.orderScheduler.controllers;

import com.DB.orderScheduler.models.UserModel;
import com.DB.orderScheduler.services.impl.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/users")
public class UserController extends BaseControllerImpl<UserModel, UserServiceImpl>{

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

    @PutMapping("/add")
    public ResponseEntity<?> registerUser(@RequestBody UserModel userModel) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.registerUser(userModel));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
