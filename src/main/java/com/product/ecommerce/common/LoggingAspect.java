package com.product.ecommerce.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
@Slf4j
public class LoggingAspect {
//    @Pointcut("within(com.product.ecommerce.service.*)")
//    public void logMethodPointCut(){
//    }
//    @Around("logMethodPointCut()")
//    public Object LogBeforeMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        log.info("method started "+proceedingJoinPoint.getSignature().getName());
//
//        Object returnValue=proceedingJoinPoint.proceed();
//        System.out.println(returnValue);
//
//        log.info("method completed:  "+proceedingJoinPoint.getSignature().getName());
//        return  returnValue;
//    }
    @Pointcut("within(com.product.ecommerce.service.*)")
    public void loggingPointCut(){

    }




    @Around("loggingPointCut()")
    public Object loggingAdvice(ProceedingJoinPoint pj)throws  Throwable{
        ObjectMapper mapper=new ObjectMapper();
        String methodName=pj.getSignature().getName();
        String className=pj.getTarget().getClass().toString();
        Object array[]=pj.getArgs();
        log.info("Inside "+className + "methodName "+methodName+" method , with request: " + mapper.writeValueAsString(array));
        Object response =pj.proceed();
        log.info("Inside "+className + "methodName "+methodName+" method , with request: "+ mapper.writeValueAsString(response));
        return response ;



    }

}
