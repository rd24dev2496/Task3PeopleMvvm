package com.example.task3peoplemvvm.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleFactory {

    private final static String BASE_URL = "https://api.randomuser.me/";
    public final static String RANDOM_USER_URL = "https://api.randomuser.me/?results=10&nat=en";
    public final static String PROJECT_URL ="https://github.com/rd24dev2496/Task2PeopleMvvm";

    public static PeopleService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(PeopleService.class);
    }
}
