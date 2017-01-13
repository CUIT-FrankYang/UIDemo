package com.example.s420.uidemo.beans;

import android.content.Intent;

/**
 * Created by s420 on 2017/1/12.
 */
public class MenuExpandChild {
    private int id;
    private String name;
    private String value;
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

    public MenuExpandChild(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
    public MenuExpandChild(int id, String name, String value,Intent intent) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.intent = intent;
    }
}
