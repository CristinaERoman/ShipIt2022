package com.example.bunnygene.contract;

import java.sql.Date;

public class PatientDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String sex;
    private String dateOfBirth;
    private Boolean privacy;
    private String notificationFrequency;

    public PatientDTO(/*String id,*/ String firstName, String lastName, String middleName, String sex, String dateOfBirth, Boolean privacy, String notificationFrequency) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.privacy = privacy;
        this.notificationFrequency = notificationFrequency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public String getNotificationFrequency() {
        return notificationFrequency;
    }

    public void setNotificationFrequency(String notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

}
