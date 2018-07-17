package com.xuan.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/17 10:12  七月
 * @Description:  AOP  业务逻辑类
 * @ModifyBy:
 */
@Component
public class MathCalculator {

    @AnnotationLog
    public int divisionMethod(int i,int j){

//        for (int ii = 0; ii < 10000; ii++) {
//            for (int jj = 0; jj < 1000; jj++) {
//                System.out.print("ii * jj = " + (ii * jj));
//            }
//            System.out.println();
//        }

        return i/j;
    }
}
