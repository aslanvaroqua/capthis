package com.nyxtech.capthis.entity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * Request object representing {@code User}.
 */
public class User {

    @Id
    private String id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String city;
    @NotEmpty
    private String state;
    @NotNull
    private int score = 0;
    @NotNull
    private int captionsCount = 0;
    @NotNull
    private int picsCount = 0;
    @NotNull
    private boolean expert = false;
    @NotEmpty
    private String imageUrl;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getCaptionsCount() {
        return captionsCount;
    }
    public void setCaptionsCount(int captionsCount) {
        this.captionsCount = captionsCount;
    }
    public void addToCaptionsCount(int number) {
        this.captionsCount = captionsCount + number;
    }

    public int getPicsCount() {
        return picsCount;
    }
    public void setPicsCount(int picsCount) {
        this.picsCount = picsCount;
    }
    public void addToPicsCount(int number) {
        this.picsCount = picsCount + number;
    }

    public boolean getExpert() {
        return this.expert;
    }
    public void setExpert() {
        this.expert = expert;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
