package com.example.servicesolidit.Model.Responses;

public class UserInfoProfileResponseDto extends ResponseDto {
    private UserInfoProfileDto response;

    public UserInfoProfileResponseDto(int code, boolean success, UserInfoProfileDto response){
        super();
        this.code = code;
        this.success = success;
        this.response = response;
    }

    public UserInfoProfileDto getResponse() {
        return response;
    }

    public void setResponse(UserInfoProfileDto response) {
        this.response = response;
    }
}
