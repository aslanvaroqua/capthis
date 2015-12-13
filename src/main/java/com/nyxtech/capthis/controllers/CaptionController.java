package com.nyxtech.capthis.controllers;

/**
 * Created by varoqua on 12/10/15.
 */

import com.nyxtech.capthis.entity.Caption;
import com.nyxtech.capthis.entity.Pic;
import com.nyxtech.capthis.models.CaptionRequest;
import com.nyxtech.capthis.repository.CaptionRepository;
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
 * REST CRUD endpoint for a caption entity.
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class CaptionController {

    /**
     * Gets a Logger
     */
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CaptionRepository captionRepository;

    /**
     * Converters.
     */
    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService conversionService;


    /**
     * Creates an {@code Caption}.
     */
    @RequestMapping(value = "captions", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public final Caption create(@Valid @RequestBody CaptionRequest captionRequest) {
        return captionRepository.save(conversionService.convert(captionRequest, Caption.class));
    }

    /**
     * Gets captions by picId.
     *
     * @param picId of pic
     */
    @RequestMapping(value = "pics/{picId}", method = RequestMethod.GET)
    public final List<Caption> findByPicId(@PathVariable("picId") final String picId) {
        log.debug("Getting captions for pic with id [{}]" , picId);
        List<Caption> captions = captionRepository.findByPicId(picId);

        if (captions != null) {
            return captions;
        } else {
            throw new EntityNotFoundException(String.format("Captions for pic with id [%s] cannot be found", picId));
        }
    }

// DELETE CAPTOPM
    // 



}