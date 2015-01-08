package com.eliagbenu.retrodemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface PersonService{

    @POST("/people/")
    public void addPerson(@Body Person person,
                          Callback<JSONObject> callback);


    @GET("/people/{id}")
    Person getPerson(@Path("id") int id);


   @GET("/people/")
    public void getPeople(Callback<List<Person>> response);

}
