/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nyxtech.capthis.repository;

import com.nyxtech.capthis.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 *
 * @author varoqua
 */
public interface UserRepository extends MongoRepository<User, Serializable> {

    public User findByEmail(String email);

    public User findByDisplayName(String displayName);

}
