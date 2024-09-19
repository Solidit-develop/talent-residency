package com.example.servicesolidit.RegisterFlow;

import com.example.servicesolidit.LoginFlow.LoginView;
import com.example.servicesolidit.Model.Dtos.User;
import com.example.servicesolidit.Model.Dtos.UserRegisterModel;
import com.example.servicesolidit.Model.Requests.RegisterRequestDto;
import com.example.servicesolidit.Model.Responses.LoginResponse;
import com.example.servicesolidit.Model.Responses.RegisterResponseDto;
import com.example.servicesolidit.Network.ApiService;
import com.example.servicesolidit.Network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {
    private ApiService service;
    private RegisterView view;

    public RegisterPresenter(RegisterView view) {
        this.view = view;
        this.service = RetrofitClient.getClient().create(ApiService.class);
    }

    public void register(RegisterRequestDto userRequest) {
        view.showProgress();
        Call<RegisterResponseDto> call = service.register(userRequest);
        call.enqueue(new Callback<RegisterResponseDto>() {
            @Override
            public void onResponse(Call<RegisterResponseDto> call, Response<RegisterResponseDto> response) {
                view.hideProgress();
                if (response.isSuccessful() && response.body() != null) {
                    view.onRegisterSuccess("Se ha enviado un correo para confirmar su identidad");
                } else {
                    view.onRegisterError("Register failed");
                }
            }

            @Override
            public void onFailure(Call<RegisterResponseDto> call, Throwable t) {
                System.out.println("Error on register: " + t.getMessage());
                view.hideProgress();
                view.onRegisterError(t.getMessage());
            }
        });
    }

}
