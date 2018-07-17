package com.xuan.aop;

import java.lang.annotation.*;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/17 13:49  七月
 * @Description:
 * @ModifyBy:
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationLog {

    public String description() default "";
}
