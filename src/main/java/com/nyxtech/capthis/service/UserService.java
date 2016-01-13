/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nyxtech.capthis.service;

import com.nyxtech.capthis.entity.User;
import com.nyxtech.capthis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author varoqua
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(String id) {
        return userRepository.findOne(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByDisplayName(String displayName) {
        return userRepository.findByDisplayName(displayName);
    }


    public void deleteAll() {
        userRepository.deleteAll();
    }

}
