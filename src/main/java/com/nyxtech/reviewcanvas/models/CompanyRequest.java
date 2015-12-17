package com.nyxtech.reviewcanvas.models;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Request object representing {@code CompanyRequest}.
 */
public class CompanyRequest {

    @NotEmpty
    @NotNull
    private String name;
    @NotNull
    private String location;
    @NotEmpty
    private String industry;
    private String description;
    private String email;

    private List<String> listOfUserIds;

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
