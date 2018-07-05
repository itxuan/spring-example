package com.xuan.bean;

import com.xuan.model.Fruit;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 12:03  七月
 * @Description:
 * @ModifyBy:
 */
public class FruitFactoryBean implements FactoryBean<Fruit> {

    private Fruit fruit;
    @Override
    public Fruit getObject() throws Exception {

        System.out.println("FruitFactoryBean getObject");
        return new Fruit();
    }

    @Override
    public Class<?> getObjectType() {
        return Fruit.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
