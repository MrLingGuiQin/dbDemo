package com.example.ling.renjingdemo;

import android.app.Application;

import com.example.ling.renjingdemo.db.DatabaseManager;
import com.facebook.stetho.Stetho;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/9/18 0018
 * ***************************************
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.getInstance().init(this);
        Stetho.initializeWithDefaults(this);
    }
}
