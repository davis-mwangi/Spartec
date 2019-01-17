/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.uuid.rest.repositories;

import com.david.uuid.models.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author david
 */
public interface UserRepository extends JpaRepository<User, UUID>{
    
}
