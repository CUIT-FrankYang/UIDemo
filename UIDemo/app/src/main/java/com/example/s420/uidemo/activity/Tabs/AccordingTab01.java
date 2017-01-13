package com.example.s420.uidemo.activity.Tabs;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.s420.uidemo.R;
import com.example.s420.uidemo.base.BaseActivity;

public class AccordingTab01 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_according_tab01);
        initBackView();
        headText.setText("according手风琴");
    }

    @Override
    protected void handler(Message msg) {

    }
}
