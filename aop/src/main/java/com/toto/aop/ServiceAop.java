package com.toto.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class ServiceAop {

    @Pointcut("execution(* com.toto.service.*.*(..))")
    void userServiceAop(){}

    @Before("userServiceAop()")
    public void userServiceBefore(JoinPoint joinPoint){
        System.out.println("运行前先执行....");
        try{
            String[] fieldsName = getFieldsName(joinPoint);
            for (int i=0;i<fieldsName.length;i++) {
                System.out.println(fieldsName[i]+":"+joinPoint.getArgs()[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取参数名列表
     * @param joinPoint
     * @return
     */
    private String[] getFieldsName(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {
        //第一步获取当前类
        //jsonPoint.getTarget() return this target Object  返回它的类，这里获取它的类名后面做反射使用
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//获取方法名，后面反射使用方法名
        //第二步获取参数的类型，这里为了防止方法重载，如果不担心重载问题这步可以忽略
        //重载根据args来获取参数的个数和参数的类型，但获取不到参数名
        Object[] args = joinPoint.getArgs();
        Class<?>[] clazzs = new Class[args.length];
        for (int i = 0;i<args.length;i++) {
            clazzs[i] = args[i].getClass();
        }
        //第三步获取参数名
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        Method method = Class.forName(className).getMethod(methodName,clazzs);//它有两个方法，可以不传入第二个参数，但为了防止方法重载，我们使用第二个方法
        return parameterNameDiscoverer.getParameterNames(method);
    }
}
