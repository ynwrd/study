package com.toto.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAop {

    @Pointcut("execution(* com.toto.service.*.*(..))")
    void userServiceAop(){}

    @Before("userServiceAop()")
    public void userServiceBefore(JoinPoint joinPoint){
        System.out.println("运行前先执行....");
    }
}
