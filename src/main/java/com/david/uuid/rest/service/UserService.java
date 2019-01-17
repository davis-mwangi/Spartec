/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.uuid.rest.service;

import com.david.uuid.models.User;
import com.david.uuid.rest.dto.UserDTO;
import com.david.uuid.rest.dto.UserUpdateDTO;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author david
 */
public interface UserService {

    /**
     *
     * @param userDTO
     * @return
     */
    public List<User> getAllUsers();
    public UserDTO addUser(UserDTO userDTO);
    public UserDTO getUser(UUID id);
    public UserDTO updateUser(UserUpdateDTO userUpdateDTO, UUID id);
    public void deleteUser(UUID id);
    
}
