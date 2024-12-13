package com.w_farooq_group.dogservice.dto;

public class ResponseDto {

    private String responseMsg;
    private String responseCode;

    public ResponseDto(String responseMsg, String responseCode) {
        this.responseMsg = responseMsg;
        this.responseCode = responseCode;
    }

    public ResponseDto() {}

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
