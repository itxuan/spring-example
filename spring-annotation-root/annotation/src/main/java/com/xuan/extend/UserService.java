package com.xuan.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/19 15:31  七月
 * @Description:
 * @ModifyBy:
 */
@Service
public class UserService {

    @EventListener(classes = {
            ContextClosedEvent.class,ContextRefreshedEvent.class
    })
    public void listen(ApplicationEvent event){

        System.out.println("UserService listen" + event);
    }
}
