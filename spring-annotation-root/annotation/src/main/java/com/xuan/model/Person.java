package com.xuan.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 08:59  七月
 * @Description:
 * @ModifyBy:
 */
public class Person {

    //1 使用@Value 注解赋值
    //   基本类型
    //  SpEL表达式  #{}
    // ${}  如 properties文件的值
    @Value("宣宝宝")
    private String name;
    @Value(value = "#{21+2}")
    private Integer age;

    @Value(value = "${person.nickName}")
    private String nickName;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Person(){}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
