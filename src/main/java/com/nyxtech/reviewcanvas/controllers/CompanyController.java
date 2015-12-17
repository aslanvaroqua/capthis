package com.nyxtech.reviewcanvas.controllers;

/**
 * Created by varoqua on 12/10/15.
 */

import com.nyxtech.reviewcanvas.entity.CheckIn;
import com.nyxtech.reviewcanvas.models.CheckInRequest;
import com.nyxtech.reviewcanvas.repository.CheckInRepository;
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
 * REST CRUD endpoint for a company entity.
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class CompanyController {

    /**
     * Gets a Logger
     */
    private Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CheckInRepository checkInRepository;

    /**
     * Converters.
     */
    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService conversionService;


    /**
     * Creates an {@code CheckIn}.
     */
    @RequestMapping(value = "check_ins", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public final CheckIn create(@Valid @RequestBody CheckInRequest checkInRequest) {
        return checkInRepository.save(conversionService.convert(checkInRequest, CheckIn.class));
    }

}