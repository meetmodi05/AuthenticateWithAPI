package com.example.authenticatewithapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit;
    private static String AUTH_URL = "https://dummyjson.com/";
    private static String AUTH_URL1 = "https://reqres.in/";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(AUTH_URL).addConverterFactory(GsonConverterFactory.create()).build();
//            System.out.println("======retrofit=====" + retrofit.create(GetMethod.class).getData().request().body());
        }
        return retrofit;

    }
}
