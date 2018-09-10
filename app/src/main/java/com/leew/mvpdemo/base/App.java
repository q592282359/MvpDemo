package com.leew.mvpdemo.base;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

/**
 * @author :Leew
 * @date ：2018/8/10 on 10:29
 * Description:
 */
public class App extends Application{

    public static App instance;
    public static Context context;


    public static App getInstance(){
        if(instance == null){
            instance  = new App();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        instance = this;
    }
}
