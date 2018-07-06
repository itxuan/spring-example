package com.xuan.model.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 14:21  七月
 * @Description:  实现Spring 提供的 InitializingBean，DisposableBean 管理对象的生命周期
 * @ModifyBy:
 */

@Component
public class Train implements InitializingBean,DisposableBean {
    public Train() {
        System.out.println("train Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("train destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("train afterPropertiesSet");
    }
}
