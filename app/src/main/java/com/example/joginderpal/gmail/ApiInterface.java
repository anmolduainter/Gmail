package com.example.joginderpal.gmail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by joginderpal on 23-04-2017.
 */
public interface ApiInterface {

    @GET("inbox.json")
    Call<List<Message>> getInbox();

}
