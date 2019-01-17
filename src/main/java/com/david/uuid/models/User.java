/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.uuid.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;



/**
 *
 * @author david
 */
@Entity
@Table(name = "users")
public class User implements DatabaseEntity, ModifiableEntity{
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name ="id", columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(name = "first_name")
    @NotBlank(message = "first_name can not be blank")
    @Size(max = 100, message = "first_name can not be more than 100 characters")
    private String firstName;
    
    
    @Column(name = "last_name")
    @NotBlank(message = "last_name can not be blank")
    @Size(max = 100, message = "last_name can not be more than 100 characters")
    private String lastName;
    
    @Column(name = "email")
    @NotBlank(message = "email can not be blank.")
    @Size(max = 100, message = "email can not be more than 100 characters.")
    private String email;
    
    @Column(name = "password")
    @NotBlank(message = "password can not be blank.")
    @Size(max = 100, message = "password can not be more than 100 characters.")
    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created = new Date();
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modified  =  new Date();

    public User() {
    }

    public User(UUID id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public UUID getId() {
       return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public Date getModified() {
       return modified;
    }

    @Override
    public void setModified(Date modified) {
        this.modified = modified;
    }

    
   
    
    
}
