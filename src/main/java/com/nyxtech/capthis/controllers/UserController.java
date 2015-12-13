package com.nyxtech.capthis.controllers;

/**
 * Created by varoqua on 12/10/15.
 */

import com.nyxtech.capthis.entity.User;
import com.nyxtech.capthis.models.UserRequest;
import com.nyxtech.capthis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST CRUD endpoint for an user entity.
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class UserController  {

    /**
     * Gets a Logger
     */
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * Converters.
     */
    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService conversionService;


    /**i
     * Creates an {@code User}.
     */
    @RequestMapping(value = "users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public final User create(@Valid @RequestBody UserRequest userRequest) {
        return userRepository.save(conversionService.convert(userRequest, User.class));
    }


    /**
     * Gets all Users.
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public final List<User> listAll() {
        log.debug("Getting all users");
        //TO DO PAGINATION
        return userRepository.findAll();
    }


    /**
     * Gets one User by Id.
     *
     * @param id id of user
     */
    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public final User findById(@PathVariable("id") final String id) {
        log.debug("Getting user with id [{}]" , id);
        User user = userRepository.findOne(id);

        if (user != null) {
            return user;
        } else {
            throw new EntityNotFoundException(String.format("User with id [%s] cannot be found", id));
        }
    }
}