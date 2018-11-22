package com.qgs.gd.fenzu;

import android.app.Application;

import com.qgs.gd.fenzu.http.OkHttp;

/**
 * date:2018/11/22    11:05
 * author:秦广帅(Lenovo)
 * fileName:App
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttp.init();
    }
}
