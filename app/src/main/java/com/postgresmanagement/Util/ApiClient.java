package com.postgresmanagement.Util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl("http://192.168.43.131:8080/api/")  // TODO: move config file.
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient());
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}
