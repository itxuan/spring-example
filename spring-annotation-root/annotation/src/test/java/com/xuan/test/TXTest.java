package com.xuan.test;

import com.xuan.beanconfig.TxConfig;
import com.xuan.service.HouseService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/18 11:23  七月
 * @Description:
 * @ModifyBy:
 */
public class TXTest {

    @Test
    public void test1(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        HouseService houseService = applicationContext.getBean(HouseService.class);
        houseService.insert();
        applicationContext.close();
    }
}
