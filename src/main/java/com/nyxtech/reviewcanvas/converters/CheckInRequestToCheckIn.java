package com.nyxtech.reviewcanvas.converters;

import com.nyxtech.reviewcanvas.entity.CheckIn;
import com.nyxtech.reviewcanvas.models.CheckInRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by varoqua on 12/10/15.
 */
@Component
public class CheckInRequestToCheckIn implements Converter<CheckInRequest, CheckIn> {

    @Override
    public CheckIn convert(CheckInRequest checkInRequest) {
        checkNotNull(checkInRequest, "Componentcaption request cannot be null");
        checkArgument(!isNullOrEmpty(checkInRequest.getUserId()), "userId cannot be null or empty");
        CheckIn checkIn = new CheckIn();
        checkIn.setUserId(checkInRequest.getUserId());
        checkIn.setImage(checkInRequest.getImage());
        checkIn.setDescription(checkInRequest.getDescription());
        checkIn.setLatitude(checkInRequest.getLatitude());
        checkIn.setLongitude(checkInRequest.getLongitude());
        checkIn.setNearLocation(checkInRequest.getNearLocation());
        checkIn.setCreated(checkInRequest.getCreated());
        return checkIn;
    }
}
