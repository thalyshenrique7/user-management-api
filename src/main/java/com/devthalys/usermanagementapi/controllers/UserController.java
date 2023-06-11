package com.devthalys.usermanagementapi.controllers;

import com.devthalys.usermanagementapi.dtos.UserDto;
import com.devthalys.usermanagementapi.models.UserModel;
import com.devthalys.usermanagementapi.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/")
    public ResponseEntity<List<UserModel>> findAll(){
        List<UserModel> allUsers = userService.findAll();
        if(allUsers.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Do not have users registered in system.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable UUID id){
        UserModel userId = userService.findById(id);
        if(userId == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or do not registered in system.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Object> save(@RequestBody UserModel user){
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered success.");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        UserModel userId = userService.findById(id);
        if(userId == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or do not registered in system.");
        }
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted success.");
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody @Valid UserDto user){
        UserModel userId = userService.findById(id);
        if(userId == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or do not registered in system.");
        }

        userId.setFirstName(user.firstName());
        userId.setSecondName(user.secondName());
        userId.setAge(user.age());
        userId.setAddress(user.address());
        userId.setCpf(user.cpf());
        userId.setRg(user.rg());
        userId.setEmail(user.email());

        userService.update(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User updated success.");
    }
}
