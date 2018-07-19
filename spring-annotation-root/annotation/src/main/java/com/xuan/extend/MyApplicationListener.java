package com.xuan.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.EventListener;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/19 11:46  七月
 * @Description:
 * @ModifyBy:
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println("MyApplicationListener.onApplicationEvent...." + event);
    }
}
