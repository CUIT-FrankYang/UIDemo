package com.example.s420.uidemo.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by s420 on 2017/1/13.
 * 立出来一个UIHandler，一般是写在Activity里面作为内部类
 */
public class UIHandler extends Handler {
    private IHandler handler;//回调接口，消息传递给注册者

    public UIHandler(Looper looper) {
        super(looper);
    }

    public UIHandler(Looper looper, IHandler handler) {
        super(looper);
        this.handler = handler;
    }

    public void setHandler(IHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (handler != null) {
            handler.handleMessage(msg);//有消息，就传递
        }
    }
    public interface IHandler {
        public void handleMessage(Message msg);
    }
}

