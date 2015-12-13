package com.nyxtech.capthis.models;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Request object representing {@code User}.
 */
public class PicRequest {


    @NotEmpty
    @NotNull
    private String userId;

    private String image64;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getImage64() {
        return image64;
    }

    public void setImage64(String image64) {
        this.image64 = image64;
    }

}