package com.nyxtech.capthis.models;
/**
 * Created by varoqua on 12/10/15.
 */
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Request object representing {@code User}.
 */
public class UserRequest {
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
    private int score = 0;
    private int captionsCount = 0;
    private int picsCount = 0;
    private boolean expert = false;
    private String imageUrl = "http://files.parsetfss.com/1ad00c84-7830-427f-ac8d-d4459361b5ce/tfss-905a97f8-9505-4ab1-aabc-5c3aef44cd35-avartar.jpeg";

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