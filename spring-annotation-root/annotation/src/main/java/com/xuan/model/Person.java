package com.xuan.model;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 08:59  七月
 * @Description:
 * @ModifyBy:
 */
public class Person {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public Person(){}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}