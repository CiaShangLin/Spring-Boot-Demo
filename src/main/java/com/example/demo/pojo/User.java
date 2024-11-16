package com.example.demo.pojo;

public class User {

    private Integer id;
    private Integer age;
    private String name;
    private String sex;
    private String address;

    public User(){

    }

    public User(Integer id, Integer age, String name, String sex, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
