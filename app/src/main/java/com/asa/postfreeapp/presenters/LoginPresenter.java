package com.asa.postfreeapp.presenters;

import com.asa.postfreeapp.api.APIClient;
import com.asa.postfreeapp.api.ApiInterface;
import com.asa.postfreeapp.models.requests.LoginRequest;
import com.asa.postfreeapp.models.response.LoginResponse;
import com.asa.postfreeapp.views.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private LoginView view;
    private ApiInterface apiInterface;

    public LoginPresenter(LoginView view){
        this.view = view;
        apiInterface = APIClient.getClient().create(ApiInterface.class);
    }

    public void login(LoginRequest req){
        view.onLoading();
        apiInterface.loginUser(req).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                view.onMidingLoading();
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                } else {
                    view.onError("Invalid input ");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                view.onMidingLoading();
                view.onError("Internal Server Error");
            }
        });
    }
}
