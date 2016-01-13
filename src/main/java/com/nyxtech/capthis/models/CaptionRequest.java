package com.nyxtech.capthis.models;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Request object representing {@code User}.
 */
public class CaptionRequest {


    @NotEmpty
    @NotNull
    private String userId;
    @NotEmpty
    @NotNull
    private String picId;
    @NotEmpty
    private String text;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPicId() { return picId; }
    public void setPicId(String picId) { this.picId = picId; }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}