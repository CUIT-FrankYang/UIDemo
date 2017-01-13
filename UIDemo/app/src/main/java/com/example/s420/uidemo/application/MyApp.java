package com.example.s420.uidemo.application;

import android.app.Application;
import android.util.Log;

/**
 * Created by s420 on 2017/1/12.
 */
public class MyApp extends Application {
    private static final String TAG = "MyApp";
    //自定义的变量
    private String param1;
    private static MyApp instance = null;
    public MyApp() {

    }
    //单例模式获取一个application对象
    public static MyApp getInstance(){
      if(instance==null){
          instance = new MyApp();
      }
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        super.onCreate();
        Log.v(TAG, "onCreate");
    }
}
