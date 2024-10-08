package com.example.servicesolidit.Model.Responses;

public class LoginResponseDto extends ResponseDto {

    private UserInfoDto response;

    public LoginResponseDto(int code, boolean success, UserInfoDto response){
        super();
        this.code = code;
        this.success = success;
        this.response = response;
    }

    public UserInfoDto getResponse(){
        return this.response;
    }

    public String getResponseMessage(){
        return this.response.toString();
    }

    public int getCode(){
        return this.code;
    }
}
