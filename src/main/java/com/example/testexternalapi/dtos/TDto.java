package com.example.testexternalapi.dtos;

public class TDto {
    String pan;
    String name;
    String firstName;
    String middleName;
    String lastName;
    String gender;
    Boolean aadhaarLinked;
    Boolean aadhaarMatch;
    String dob;
    String mobileNo;
    String emailId;


    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getAadhaarLinked() {
        return aadhaarLinked;
    }

    public void setAadhaarLinked(Boolean aadhaarLinked) {
        this.aadhaarLinked = aadhaarLinked;
    }

    public Boolean getAadhaarMatch() {
        return aadhaarMatch;
    }

    public void setAadhaarMatch(Boolean aadhaarMatch) {
        this.aadhaarMatch = aadhaarMatch;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "TDto{" +
                "pan='" + pan + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", aadhaarLinked=" + aadhaarLinked +
                ", aadhaarMatch=" + aadhaarMatch +
                ", dob='" + dob + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}