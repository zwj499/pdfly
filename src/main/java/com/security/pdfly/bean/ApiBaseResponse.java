package com.security.pdfly.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiBaseResponse<T> {
    private static final String SUCCESS_CODE = "00";
    private String requestId;
    private String responseCode;
    private String responseMessage;
    private T data;

    public boolean isSuccess() {
        return "00".equals(this.responseCode);
    }

    public ApiBaseResponse(String code, String msg) {
        this.responseCode = code;
        this.responseMessage = msg;
    }

    public ApiBaseResponse() {
    }

    public ApiBaseResponse(T data) {
        this.data = data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "ApiBaseResponse{requestId='" + this.requestId + '\'' + ", responseCode='" + this.responseCode + '\'' + ", responseMessage='" + this.responseMessage + '\'' + '}';
    }

}