package com.nyxtech.capthis.entity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Request object representing {@code User}.
 */
public class Pic {

    @Id
    private String id;

    @NotEmpty
    @NotNull
    private String userId;

    private String image64;

    private int upVotes = 0;
    private int downVotes = 0;

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

    public int getUpVotes() {
        return upVotes;
    }
    public int getDownVotes() {
        return downVotes;
    }
    public void addUpVotes() {
        upVotes = upVotes + 1;
    }
    public void addDownVotes() {
        downVotes = downVotes + 1;
    }
}
