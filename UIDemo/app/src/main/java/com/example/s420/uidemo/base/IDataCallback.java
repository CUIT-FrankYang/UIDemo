package com.example.s420.uidemo.base;

/**
 * Created by s420 on 2017/1/13.
 * 数据回调接口，我们从网络端获取数据 需要通知给UI
 */
public interface IDataCallback<T> {
    public void onNewData(T data);
    public void onError(String msg,int code);
}
