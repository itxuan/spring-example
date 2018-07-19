package com.xuan.test;


import com.xuan.extend.ExtendConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/19 10:14  七月
 * @Description:  扩展原理测试
 * @ModifyBy:
 */
public class ExtendTest {


    @Test
    public void test(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtendConfiguration.class);

        String string = "时间一直向前走";
        applicationContext.publishEvent(new ApplicationEvent(string){
        });

        applicationContext.close();
    }
}
