package com.example.s420.uidemo.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s420.uidemo.R;
import com.example.s420.uidemo.beans.Employee;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    // 可以把常量单独放到一个Class中
    public static final String ACTION_NETWORK_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String ACTION_PUSH_DATA = "fm.data.push.action";
    public static final String ACTION_NEW_VERSION = "apk.update.action";

    protected static UIHandler handler = new UIHandler(Looper.getMainLooper());

    // 数据回调接口，都传递Domine的子类实体
    protected IDataCallback<MData<? extends Domine>> dataCallback;

    public TextView headText;
    public ImageView backimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
        setBase();
        setHandler();
        initContentView(savedInstanceState);
        initBackView();
//        initListener();
    }

    public void initBackView() {
        headText = (TextView) findViewById(R.id.head_title);
        backimg = (ImageView) findViewById(R.id.back);
        backimg.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
        }
    }

    private void setHandler() {
        handler.setHandler(new UIHandler.IHandler() {
            public void handleMessage(Message msg) {
                handler(msg);//有消息就提交给子类实现的方法
            }
        });
    }

    // 初始化UI，setContentView等
    protected abstract void initContentView(Bundle savedInstanceState);

    // 可能全屏或者没有ActionBar等
    private void setBase() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 例
    }

    protected void addLeftMenu(boolean enable) {
        // 如果你的项目有侧滑栏可以处理此方法
        if (enable) { // 是否能有侧滑栏

        } else {

        }
    }
    //让子类处理消息
    protected abstract void handler(Message msg);


    // 横竖屏切换，键盘等
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        try {
            super.onRestoreInstanceState(savedInstanceState);
        } catch (Exception e) {
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 你可以添加多个Action捕获
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_NETWORK_CHANGE);
        filter.addAction(ACTION_PUSH_DATA);
        filter.addAction(ACTION_NEW_VERSION);
        registerReceiver(receiver, filter);
        //还可能发送统计数据，比如第三方的SDK 做统计需求
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        //还可能发送统计数据，比如第三方的SDK 做统计需求
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 处理各种情况
            String action = intent.getAction();
            if (ACTION_NETWORK_CHANGE.equals(action)) { // 网络发生变化
                // 处理网络问题
            } else if (ACTION_PUSH_DATA.equals(action)) { // 可能有新数据
                Bundle b = intent.getExtras();
                MData<Employee> mdata = (MData<Employee>) b.get("data");
                if (dataCallback != null) { // 数据通知
                    dataCallback.onNewData(mdata);
                }
            } else if (ACTION_NEW_VERSION.equals(action)) { // 可能发现新版本
                // VersionDialog 可能是版本提示是否需要下载的对话框
            }
        }
    };

    public void setDataCallback(
            IDataCallback<MData<? extends Domine>> dataCallback) {
        this.dataCallback = dataCallback;
    }
}
