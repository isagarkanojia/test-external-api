package com.example.testexternalapi.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
}