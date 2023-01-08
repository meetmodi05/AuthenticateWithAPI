package com.example.authenticatewithapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMethod {
    @GET("users")
    Call<HashMap> getData();
}
