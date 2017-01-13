package com.example.s420.uidemo.beans;

import com.example.s420.uidemo.base.Domine;

/**
 * Created by s420 on 2017/1/13.
 */
//Domine为通用实体类，后面可作为泛型参数有用
public class Employee extends Domine  {
    private static final long serialVersionUID = 1L;

    public Employee() {
    }

    public String fullName;
    public String mobileTel;
    public String email;
    public String empNo;

}
