package com.xuan.model.lifecycle;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 14:34  七月
 * @Description:
 * @ModifyBy:
 */

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Sheep {


    public Sheep() {

        System.out.println("Sheep...Constructor...");
    }

    @PostConstruct
    public void init(){
        System.out.println("Sheep...PostConstruct...init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Sheep...destroy");
    }
}
