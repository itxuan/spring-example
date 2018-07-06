package com.xuan.model.lifecycle;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 14:02  七月
 * @Description:
 * @ModifyBy:
 */
public class Car {

    public Car(){
        System.out.println("car...constructor...");
    }

    public void init(){

        System.out.println("car...init...");
    }

    public void destroy(){
        System.out.println("car...destroy...");
    }
}
