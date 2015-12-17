package com.nyxtech.reviewcanvas.models;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Request object representing {@code CheckInRequest}.
 */
public class CheckInRequest {

    @NotEmpty
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    @NotEmpty
    private String nearLocation;
    @NotEmpty
    private String description;
    private String image;
    @NotEmpty
    @NotNull
    private String userId;
    @NotNull
    @NotEmpty
    private String created;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getNearLocation () {
        return nearLocation;
    }
    public void setNearLocation(String nearLocation) {
        this.nearLocation = nearLocation;
    }


    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated() {
        return this.created;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
