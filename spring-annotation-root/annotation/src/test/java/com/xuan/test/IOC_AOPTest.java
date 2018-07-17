package com.xuan.test;

import com.xuan.aop.MathCalculator;
import com.xuan.beanconfig.IocConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/17 14:02  七月
 * @Description:
 * @ModifyBy:
 */
public class IOC_AOPTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfigOfAOP.class);

        //对象需要由Spring容器管理
        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);

        System.out.println(calculator.divisionMethod(10000, 0));
    }
}
