package com.xuan.beanconfig;

import com.xuan.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/6 08:52  七月
 * @Description: @Value spring 属性赋值
 * @ModifyBy:
 */

// @PropertySource 读取外部的配置文件保存到运行的环境变量中
//    windows cmd 汉字转换成ascii编码 使用jdk 提供的native2ascii.exe 可参考 https://www.cnblogs.com/shindo/p/4959447.html
//    另外idea提供property 属性文件中文自动转ascii,File ->Setting -> File Encodings  :Transparent native-to-ascii  conversion打勾

    //@PropertySources 看接口value 为PropertySource[]

//@PropertySource(value = {"classpath:/person.properties"})
@Configuration
@PropertySources(value = {
        @PropertySource(value = {"classpath:/person.properties"})
})
public class IocConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
