package com.nyxtech.reviewcanvas.entity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Request object representing {@code Company}.
 */
public class Company {

    @Id
    private String id;
    @NotEmpty
    @NotNull
    private String name;
    @NotNull
    private String location;
    @NotEmpty
    private String industry;
    private String description;
    private String email;
    private String userName;
    private String password;

    private List<String> listOfUserIds;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setListOfUserIds(List<String> userIds) {
        this.listOfUserIds = listOfUserIds;
    }

    public List<String> getListOfUserIds() {
        return this.listOfUserIds;
    }

}
