package com.DB.orderScheduler.controllers;

import com.DB.orderScheduler.dto.UserDTO;
import com.DB.orderScheduler.models.RoleType;
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
    public ResponseEntity<?> searchById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        try {
            UserModel userModel = service.addUser(userDTO);
            UserDTO resultDTO = service.convertToDTO(userModel);
           return ResponseEntity.ok(resultDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/{email}/addRole")
    public ResponseEntity<?> addRoleToUser(@PathVariable String email, @RequestParam RoleType role) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.addRoleToUser(email, role));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
