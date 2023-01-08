package com.example.authenticatewithapi;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostMethod {
    @POST("users/add")
//    Call<RegistraionModel> getRegistrationModelCall(@Field("firstName") String firstname, @Field("lastName") String lastname);
    Call<RegistraionModel> getRegistrationModelCall(@Body HashMap<String, String> regisHashMap);


}
