package com.example.testexternalapi.dtos;

public class Request {
    String pan;
    String aadhaarLastFour;
    String consent;
    String getContactDetails;


    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAadhaarLastFour() {
        return aadhaarLastFour;
    }

    public void setAadhaarLastFour(String aadhaarLastFour) {
        this.aadhaarLastFour = aadhaarLastFour;
    }

    public String getConsent() {
        return consent;
    }

    public void setConsent(String consent) {
        this.consent = consent;
    }

    public String getGetContactDetails() {
        return getContactDetails;
    }

    public void setGetContactDetails(String getContactDetails) {
        this.getContactDetails = getContactDetails;
    }
}
