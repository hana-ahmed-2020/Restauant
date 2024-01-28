package com.example.restau;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseInstallation;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("G12WDJBow9kqE5qCdhXT2ww7x5Ngbec16T1SxAqs")
                .clientKey("YiKB3tCOBsd1guNRNE9B4kq5zheOT7wAsFHlk19T")
                .server("https://parseapi.back4app.com/")
                .build());

        ParseInstallation.getCurrentInstallation().saveInBackground();



    }
}