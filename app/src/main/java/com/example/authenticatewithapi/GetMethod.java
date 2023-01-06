package com.example.authenticatewithapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMethod {
    @GET("users")
    Call<RegistraionModel> getData();
}
