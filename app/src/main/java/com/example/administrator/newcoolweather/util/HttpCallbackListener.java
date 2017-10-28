package com.example.administrator.newcoolweather.util;

/**
 * Created by Administrator on 2017/10/27.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
