package com.nyxtech.capthis.entity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Request object representing {@code User}.
 */
public class Caption {

    @Id
    private String id;

    @NotEmpty
    @NotNull
    private String userId;

    @NotEmpty
    @NotNull
    private String picId;
    @NotEmpty
    private String text;
    private int upVotes = 0;
    private int downVotes = 0;
    public String getId() {return id;}
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
