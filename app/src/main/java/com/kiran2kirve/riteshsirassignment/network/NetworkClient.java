package com.kiran2kirve.riteshsirassignment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//https://api.randomuser.me/?results=10&nat=en
//url

public class NetworkClient {
    public static final String BASE_URL = "https://api.randomuser.me";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }




/*    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(interceptor).build()).build();
        }
        return retrofit;
    }*/

}
