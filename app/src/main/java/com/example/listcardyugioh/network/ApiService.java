package com.example.listcardyugioh.network;

import com.example.listcardyugioh.model.response.CardResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/v5/cardinfo.php")
    Call<List<CardResponse>> getCard(@Query("type")String type);
}
