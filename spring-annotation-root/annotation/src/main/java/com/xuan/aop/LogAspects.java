package com.xuan.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.*;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/17 10:14  七月
 * @Description:
 *
 *          AOP参考网址 ：
 *              http://www.cnblogs.com/-bumblebee-/archive/2012/03/29/2423408.html
 *              http://hotstrong.iteye.com/blog/1330046
 *              https://blog.csdn.net/z2007130205/article/details/25713843
 *
 * @ModifyBy:
 */
@Component
@Aspect
public class LogAspects {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspects.class);

    private Long takeTime = 0L;
    private Long startTime = 0L;
    private Long endTime = 0L;

    public LogAspects() {
        LOGGER.info("[Init LogAspects]");
    }

    @Pointcut(value = "@annotation(com.xuan.aop.AnnotationLog)")
    public void method(){

    }

    @Around(value = "method()")
    public Object aroundLog(final ProceedingJoinPoint pjp) throws Throwable {

        logBefore(pjp);
        Object returnVal = pjp.proceed();
        ObjectMapper objectMapper = new ObjectMapper();

        // json  转换
        LOGGER.info("3、 方法返回值：" + objectMapper.writeValueAsString(returnVal));

        logAfter();
        return returnVal;
    }

    // 方法开始 JoinPoint 必须出现在参数表的第一位
    public void logBefore(JoinPoint joinPoint) throws ClassNotFoundException, NotFoundException {

        String name = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(name);
        String clazzName = clazz.getName();

        String className = joinPoint.getThis().toString();
        // signature 方法签名 就是方法名
        String methodMethod = joinPoint.getSignature().getName();
        startTime = System.currentTimeMillis();
        LOGGER.info("======================日志记录 start ===========================");
        LOGGER.info("1、 当前访问的类====>  " + className);
        LOGGER.info("2、 调用方法开始====>  " + methodMethod);

        Object[] args = joinPoint.getArgs();
        if (args.length <= 0) {
            LOGGER.info(methodMethod + " 方法没有参数");
        } else {
            // 获取方法的所有参数
            String[] fieldsName = getFieldsName(this.getClass(), clazzName, methodMethod);
            LOGGER.info("------------方法的参数和值遍历  start  ---------------------");
            for (int i = 0; i < args.length; i++) {
                LOGGER.info("参数名：" + fieldsName[i] + "，该参数值是 { " + args[i] + " }");
            }
            LOGGER.info("------------方法的参数和值遍历  end  ---------------------");
        }
//        LOGGER.info("@Before end");
    }

    //方法结束
    public void logAfter() {
        endTime = System.currentTimeMillis();
        LOGGER.info("==============================================================");
        takeTime = endTime - startTime;
        LOGGER.info("4、该方法花费时间:   " + takeTime +" ms");

        // 调用方法性能判断
        Long seconds = takeTime/1000;
        if(seconds > 10) {
            LOGGER.info("Method:cost { "+ seconds +" } seconds, Severity warning");
        }else if (seconds >  5 && seconds <10){

            LOGGER.info("Method:cost { "+seconds+" }seconds, Warning");
        }
        LOGGER.info("======================日志记录 end ===========================");
    }


//    @AfterThrowing(value = "method()",throwing = "t")
//    public void logThrowable(JoinPoint joinPoint,Throwable t){
//
//        LOGGER.error("出现异常的方法："+ joinPoint.getSignature().getName()+"传入参数{ "
//                + Arrays.asList(joinPoint.getArgs()) +" }",t);
//    }

    /**
     *   通过 字节码的反射方法得到方法的参数名称
     * @param clazz
     * @param clazzName
     * @param methodName
     * @return
     * @throws NotFoundException
     */
    private final static String[] getFieldsName(Class<?> clazz, String clazzName, String methodName) throws NotFoundException {

        ClassPool classPool = ClassPool.getDefault();
        ClassClassPath classClassPath = new ClassClassPath(clazz);
        classPool.insertClassPath(classClassPath);
        CtClass cc = classPool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        CodeAttribute codeAttribute = cm.getMethodInfo().getCodeAttribute();

        AttributeInfo attribute = codeAttribute.getAttribute(LocalVariableAttribute.tag);
        System.out.println(attribute);
        if (attribute == null) {
            //exception

        }
        //parameterTypes 即参数名
        String[] parameterTypes = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = ((LocalVariableAttribute) attribute).variableName(i + pos);
        }
        return parameterTypes;
    }
}
