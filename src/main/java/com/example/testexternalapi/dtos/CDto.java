package com.example.testexternalapi.dtos;


public class CDto {
    String requestId;
    TDto result;
    Integer statusCode;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public TDto getResult() {
        return result;
    }

    public void setResult(TDto result) {
        this.result = result;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }


    @Override
    public String toString() {
        return "CDto{" +
                "requestId='" + requestId + '\'' +
                ", result=" + result +
                ", statusCode=" + statusCode +
                '}';
    }
}
