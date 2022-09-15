package com.example.testexternalapi.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Request {
    String pan;
    String aadhaarLastFour;
    String consent;
    String getContactDetails;
}
