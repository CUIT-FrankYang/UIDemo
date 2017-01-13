package com.example.s420.uidemo.base;

import java.io.Serializable;

/**
 * Created by s420 on 2017/1/13.
 * 数据交互的模型
 */
public class MData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public String id;
    public String type;
    public T dataList;//多种类型数据，一般是List集合，比如获取所有员工列表
}
