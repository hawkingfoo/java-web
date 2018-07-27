package com.hawkingfoo.model;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private List<String> cities; // 常去的城市

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

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
