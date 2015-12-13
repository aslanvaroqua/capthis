package com.nyxtech.capthis.converters;

import com.nyxtech.capthis.entity.Caption;
import com.nyxtech.capthis.models.CaptionRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by varoqua on 12/10/15.
 */
@Component
public class CaptionRequestToCaption implements Converter<CaptionRequest, Caption> {

    @Override
    public Caption convert(CaptionRequest captionRequest) {
        checkNotNull(captionRequest, "caption request cannot be null");
        checkArgument(!isNullOrEmpty(captionRequest.getUserId()), "userId cannot be null or empty");
        checkArgument(!isNullOrEmpty(captionRequest.getText()), "text cannot be null or empty");
        checkArgument(!isNullOrEmpty(captionRequest.getPicId()), "picId cannot be null or empty");
        Caption caption = new Caption();
        caption.setUserId(captionRequest.getUserId());
        caption.setPicId(captionRequest.getPicId());
        caption.setText(captionRequest.getText());
        return caption;
    }
}
