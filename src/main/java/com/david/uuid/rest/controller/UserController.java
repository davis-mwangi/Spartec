/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.uuid.rest.controller;

import com.david.uuid.models.User;
import com.david.uuid.rest.dto.UserDTO;
import com.david.uuid.rest.dto.UserUpdateDTO;
import com.david.uuid.rest.response.SuccessResponse;
import com.david.uuid.rest.service.UserService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<UserDTO>addUser(@Valid @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }
    
    @GetMapping("/users")
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    
    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestParam(value = "id") UUID id) {
         return ResponseEntity.ok(userService.getUser(id));
    }
    
    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserUpdateDTO 
            userUpdateDTO, @RequestParam(value ="id") UUID id){
        return ResponseEntity.ok(userService.updateUser(userUpdateDTO, id));
    }
    
    @DeleteMapping
    public ResponseEntity<?>deleteUser(@RequestParam(value = "id") UUID id){
       return ResponseEntity.ok(new SuccessResponse("deleted"));
    }
    
}
