package com.example.authenticatewithapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMethod {
    @GET("users?firstName&lastName&email")
    Call<RegistraionModel> getData();
}
