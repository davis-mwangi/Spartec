/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.uuid.rest.service;

import com.david.uuid.models.User;
import com.david.uuid.rest.dto.UserDTO;
import com.david.uuid.rest.dto.UserUpdateDTO;
import com.david.uuid.rest.repositories.UserRepository;
import com.david.uuid.rest.exception.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public UserDTO addUser(UserDTO userDTO) {
          Date now  = new Date();
          
          User user  = new User();
          user.setFirstName(userDTO.getFirstName());
          user.setLastName(userDTO.getLastName());
          user.setEmail(userDTO.getEmail());
          user.setPassword(userDTO.getPassword());
          user.setCreated(now);
          user.setModified(now);
          userRepository.save(user);
          
          /*set generated user id to response object */
          userDTO.setId(user.getId());
          userDTO.setPassword("");
          return userDTO;
    }

    @Override
    public UserDTO getUser(UUID id) {
       User user = userRepository.getOne(id);
       if(Objects.isNull(user)){
           throw new EntityNotFoundException(User.class, id);
       }
       return new UserDTO().build(user);
    }

    @Override
    public UserDTO updateUser(UserUpdateDTO userUpdateDTO, UUID id) {
       User user =  userRepository.getOne(id);
       if(Objects.isNull(user)){
           throw new EntityNotFoundException(User.class, id);
       }
       user.setFirstName(userUpdateDTO.getFirstName());
       user.setLastName(userUpdateDTO.getLastName());
       userRepository.save(user);
       return new UserDTO().build(user);
    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteUser(UUID id) {
       userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
      return  userRepository.findAll();
    }

    
    
}
