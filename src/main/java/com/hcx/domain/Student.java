package com.hcx.domain;

/**
 * Student实体类
 * Created by HCX on 2019/3/10.
 */
public class Student {

    //主键
    private int id;

    //姓名
    private String name;

    //年龄
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
