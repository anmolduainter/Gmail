package com.example.joginderpal.gmail;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joginderpal on 23-04-2017.
 */
public class APIClient {

    private static final String BASE_URL="http://api.androidhive.info/json/";
    private static Retrofit retrofit=null;
    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
