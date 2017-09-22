package com.example.helvi.thedoctorsapplication.activities.service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
   public static  Retrofit retrofit=null;

    public static Retrofit getClient(String URL)
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                      .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



}
