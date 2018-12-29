package com.example.mac.myapplication.modelo;

public class User {
    private String name;
    private String las_name;
    private String age;

    public User(String name, String las_name, String age) {
        this.name = name;
        this.las_name = las_name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLas_name() {
        return las_name;
    }

    public void setLas_name(String las_name) {
        this.las_name = las_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
