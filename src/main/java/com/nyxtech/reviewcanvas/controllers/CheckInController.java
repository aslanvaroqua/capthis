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
 * REST CRUD endpoint for a checkIn entity.
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class CheckInController {

    /**
     * Gets a Logger
     */
    private Logger log = LoggerFactory.getLogger(CheckInController.class);

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

    /**
     * Gets checkIns by picId.
     *
     * @param picId of pic
     */
    @RequestMapping(value = "check_ins/{userId}", method = RequestMethod.GET)
    public final List<CheckIn> findByUserId(@PathVariable("userId") final String picId) {
        log.debug("Getting checkIns for pic with id [{}]" , picId);
        List<CheckIn> checkIns = checkInRepository.findByUserId(picId);

        if (checkIns != null) {
            return checkIns;
        } else {
            throw new EntityNotFoundException(String.format("CheckIns for pic with id [%s] cannot be found", picId));
        }
    }

    /// UPDATE CHECKIN

    /// DELETE CHECKIN


}