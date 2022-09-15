package com.example.testexternalapi.dtos;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CDto {
    String requestId;
    TDto result;
    Integer statusCode;

}
