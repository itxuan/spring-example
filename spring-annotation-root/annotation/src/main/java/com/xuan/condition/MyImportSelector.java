package com.xuan.condition;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 11:31  七月
 * @Description: 自定义逻辑返回需要导入的组件(String 数组)
 * @ModifyBy:
 */
public class MyImportSelector implements ImportSelector {

    /**
     * Select and return the names of which class(es) should be imported based on
     * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
     * 返回值是要导入容器中的所有组件全限定名
     *  AnnotationMetadata 表示当前使用@Import注解的类的所有注解
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //方法的返回值不可以是null
        return new String[]{"com.xuan.model.ImportBlue","com.xuan.model.ImportYellow"};
    }
}
