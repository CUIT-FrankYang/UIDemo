package com.example.s420.uidemo.beans;

import android.content.Intent;

import java.util.List;

/**
 * Created by s420 on 2017/1/12.
 */
public class MenuExpandParent {
    private int id;
    private String name;
    private String value;
    private List<MenuExpandChild> childs;
    private Intent intent;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<MenuExpandChild> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuExpandChild> childs) {
        this.childs = childs;
    }

    public MenuExpandParent(List<MenuExpandChild> childs) {
        this.childs = childs;

    }

    public MenuExpandParent(int id, String name, String value, List<MenuExpandChild> childs) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.childs = childs;
    }
    public MenuExpandParent(int id, String name, String value, List<MenuExpandChild> childs,Intent intent) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.childs = childs;
        this.intent = intent;
    }
}
