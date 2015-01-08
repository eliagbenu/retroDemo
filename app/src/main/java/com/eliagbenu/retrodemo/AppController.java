package com.eliagbenu.retrodemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import java.sql.SQLException;

import retrofit.RestAdapter;

/**
 * Created by eli on 1/5/15.
 */
public class AppController extends Application {

    public static Context context ;
    public static AppController appController ;
    public static PersonService personService ;

    final static String API_URL = "https://retrodemo.herokuapp.com";


    public AppController() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        appController = this;

        startPersonService();

    }


    void startPersonService(){
        RestAdapter restAdapter = new RestAdapter
                .Builder()
                .setEndpoint(API_URL)
                .build();
        personService = restAdapter.create(PersonService.class);
        Log.e("xxxxxxxxxxxxxx",""+personService);

    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
