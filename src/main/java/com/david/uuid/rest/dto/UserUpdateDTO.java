/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.uuid.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

/**
 *Object to interact using rest api.
 * @author david
 */
public class UserUpdateDTO {
    
    @NotEmpty(message = "first_name can not be empty")
    @JsonProperty("first_name")
    private String firstName;
    
    @NotEmpty(message = "last_name cannot be empty")
    @JsonProperty("last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
}
