package com.qgs.gd.fenzu.model;

import android.os.Handler;
import android.os.Message;

import com.qgs.gd.fenzu.http.OkHttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/11/22    13:20
 * author:秦广帅(Lenovo)
 * fileName:RightModel
 */
public class RightModel {
    public void right(String url, final HttpCallBack httpCallBack){
        OkHttp.queneGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String ss = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.setData(ss);
                    }
                });
            }
        });
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public interface HttpCallBack{
        void setData(String ss);
    }
}
