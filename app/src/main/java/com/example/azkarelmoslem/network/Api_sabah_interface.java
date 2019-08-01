package com.example.azkarelmoslem.network;

import com.example.azkarelmoslem.models.Azkar_Content;
import com.example.azkarelmoslem.models.Zekr;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_sabah_interface
{
    @GET("azkar_sabah.json")
    Call<Zekr> get_azkar();
}
