package com.xuan.test;

import com.xuan.beanconfig.IocConfigOfLifeCycle;
import com.xuan.model.lifecycle.Car;
import com.xuan.model.lifecycle.Train;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 14:04  七月
 * @Description:
 * @ModifyBy:
 */
public class IOC_LifeCycleTest {


    @Test
    public void lifecycleOfTrain(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfigOfLifeCycle.class);
        Train bean = applicationContext.getBean(Train.class);
        System.out.println(bean);
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Test
    public void lifecycleOfCar(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfigOfLifeCycle.class);
        System.out.println("ioc 容器创建");
//        System.out.println(applicationContext.getBean(Car.class));
//        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
