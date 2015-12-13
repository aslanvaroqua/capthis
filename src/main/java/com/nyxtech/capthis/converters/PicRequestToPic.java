package com.nyxtech.capthis.converters;

import com.nyxtech.capthis.entity.Pic;
import com.nyxtech.capthis.models.PicRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by varoqua on 12/10/15.
 */
@Component
public class PicRequestToPic implements Converter<PicRequest, Pic> {

    @Override
    public Pic convert(PicRequest picRequest) {
        checkNotNull(picRequest, "pic request cannot be null");
        checkArgument(!isNullOrEmpty(picRequest.getUserId()), "userId cannot be null or empty");
        checkArgument(!isNullOrEmpty(picRequest.getImage64()), "image64 cannot be null or empty");
        Pic pic = new Pic();
        pic.setUserId(picRequest.getUserId());
        pic.setImage64(picRequest.getImage64());
        return pic;
    }
}
