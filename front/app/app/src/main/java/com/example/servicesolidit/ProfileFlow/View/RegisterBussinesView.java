package com.example.servicesolidit.ProfileFlow.View;

import com.example.servicesolidit.Utils.Models.Responses.User.UpdateUserToProviderResponseDto;

public interface RegisterBussinesView {
    void showProgress();
    void hideProgress();
    void onRegisterSuccess(String responseMessage);
    void onRegisterFails(String s);
}