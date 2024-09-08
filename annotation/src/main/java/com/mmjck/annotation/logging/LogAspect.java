package com.mmjck.annotation.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(Log)")
    public Object automaticLog(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("init - " + jp.getSignature());
        var result =  jp.proceed();
        System.out.println("end - " + jp.getSignature());


        return result;

    }
}
