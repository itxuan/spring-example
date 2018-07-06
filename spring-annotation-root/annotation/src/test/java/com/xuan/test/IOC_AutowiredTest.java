package com.xuan.test;

import com.xuan.beanconfig.IocConfigOfAutowired;
import com.xuan.beanconfig.IocConfigOfLifeCycle;
import com.xuan.dao.BookDao;
import com.xuan.model.lifecycle.Train;
import com.xuan.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/6 9:33  七月
 * @Description:
 * @ModifyBy:
 */
public class IOC_AutowiredTest {


    @Test
    public void lifecycleOfTrain(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfigOfAutowired.class);

        System.out.println(applicationContext.getBean(BookService.class));
//        System.out.println(applicationContext.getBean(BookDao.class));

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

}
