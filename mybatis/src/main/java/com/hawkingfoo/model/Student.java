package com.hawkingfoo.model;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int sex;    // 0=male, 1=female
    private String addr;

    public Student() {
    }

    public Student(String name, int sex, String addr) {
        this.name = name;
        this.sex = sex;
        this.addr = addr;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
