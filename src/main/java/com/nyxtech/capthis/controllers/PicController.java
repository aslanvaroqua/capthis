package com.nyxtech.capthis.controllers;

/**
 * Created by varoqua on 12/10/15.
 */

import com.nyxtech.capthis.entity.Pic;
import com.nyxtech.capthis.models.PicRequest;
import com.nyxtech.capthis.repository.PicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * REST CRUD endpoint for a pic entity.
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class PicController  {

    /**
     * Gets a Logger
     */
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private PicRepository picRepository;

    /**
     * Converters.
     */
    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService conversionService;


    /**i
     * Creates an {@code Pic}.
     */
    @RequestMapping(value = "pics", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public final Pic create(@Valid @RequestBody PicRequest picRequest) {
        return picRepository.save(conversionService.convert(picRequest, Pic.class));
    }

    /**
     * Gets one Pic by Id.
     *
     * @param id id of pic
     */
    @RequestMapping(value = "pics/{id}", method = RequestMethod.GET)
    public final Pic findById(@PathVariable("id") final String id) {
        log.debug("Getting pic with id [{}]" , id);
        Pic pic = picRepository.findOne(id);

        if (pic != null) {
            return pic;
        } else {
            throw new EntityNotFoundException(String.format("Pic with id [%s] cannot be found", id));
        }
    }

}