package com.xuan.beanconfig;

import com.xuan.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 09:00  七月
 * @Description:  spring 注解配置类@Configuration
 * @ModifyBy:
 */
@Configuration
public class PersonConfig {

    /**
     * 方法名表示Id  返回类型   @Bean 的name 表示Id
     * @return
     */
    @Bean(name = "zhangSanName")
    public Person person001(){
        return new Person("张三",11);
    }
}
