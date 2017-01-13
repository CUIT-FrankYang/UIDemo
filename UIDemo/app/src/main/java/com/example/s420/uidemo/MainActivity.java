package com.example.s420.uidemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.s420.uidemo.activity.Tabs.AccordingTab01;
import com.example.s420.uidemo.activity.Tabs.MoreTextViewActivity;
import com.example.s420.uidemo.adapter.MenuExpandAdapter;
import com.example.s420.uidemo.beans.MenuExpandChild;
import com.example.s420.uidemo.beans.MenuExpandParent;
import com.example.s420.uidemo.utils.FontUtils;
import com.example.s420.uidemo.views.AccordionView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandView;
    private List<MenuExpandParent> menuParents;
    private ExpandableListAdapter expandAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initAdapter();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        menuParents = new ArrayList<MenuExpandParent>();

        //折叠面板
        List<MenuExpandChild> childsTab = new ArrayList<>();
        childsTab.add(new MenuExpandChild(0,"手风琴效果01","",new Intent(this,AccordingTab01.class)));
        childsTab.add(new MenuExpandChild(0,"多行文本折叠效果2","",new Intent(this,MoreTextViewActivity.class)));
        menuParents.add(new MenuExpandParent(0,"accordion(折叠面板)","",childsTab));

        //操作表
        List<MenuExpandChild> childsTable = new ArrayList<>();
        childsTable.add(new MenuExpandChild(0,"H5模式Actionsheet",""));
        menuParents.add(new MenuExpandParent(1,"actionsheet(操作表)","",childsTable));

        //数字角标
        menuParents.add(new MenuExpandParent(2,"badge'(数字角标)","",null));

        //按钮
        List<MenuExpandChild> childsBtn = new ArrayList<>();
        childsBtn.add(new MenuExpandChild(0,"普通按钮",""));
        childsBtn.add(new MenuExpandChild(1,"带图标的按钮",""));
        childsBtn.add(new MenuExpandChild(2,"带数字的按钮",""));
        childsBtn.add(new MenuExpandChild(3,"块级按钮",""));
        menuParents.add(new MenuExpandParent(3,"button'(按钮)","",childsBtn));
    }

    /**
     * 初始化适配器
     */
        private void initAdapter() {
            expandAdapter = new MenuExpandAdapter(this,menuParents);
            expandView.setAdapter(expandAdapter);
        }

    /**
     * 初始化视图
     */
    private void initView() {
        expandView = (ExpandableListView) findViewById(R.id.expanded_menu);
    }





}
