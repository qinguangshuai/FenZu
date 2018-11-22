package com.qgs.gd.fenzu.http;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * date:2018/11/22    11:02
 * author:秦广帅(Lenovo)
 * fileName:OkHttp
 */
public class OkHttp {
    //get请求
    private static final String MEDIO_GET = "GET";
    private static OkHttpClient client;

    //单例模式
    private OkHttp(){}

    public static void init(){
        client = new OkHttpClient.Builder()
                .connectTimeout(3000,TimeUnit.MILLISECONDS)
                .readTimeout(3000,TimeUnit.MILLISECONDS)
                .writeTimeout(3000,TimeUnit.MILLISECONDS)
                .build();
    }

    public static Request creat(String url,String method){
        Request.Builder builder = new Request.Builder().url(url);
        Request request = null;
        switch (method){
            case MEDIO_GET:
                 request = builder.build();
                break;
        }
        return request;
    }

    public static void queneGet(String url, Callback callback){
        Request request = creat(url, MEDIO_GET);
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
