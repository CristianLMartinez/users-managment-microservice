package com.cristian.tiusers.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class MonitoringAspect {

    @Pointcut("@annotation(com.cristian.tiusers.aspect.Monitor)")
    public void monitorAnnotationPointCut(){}

    private final Logger logger = LoggerFactory.getLogger(MonitoringAspect.class);

    @After("monitorAnnotationPointCut()")
    public void logMethodExecution(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info(String.format("method [%s] executed %s", methodName, Arrays.toString(joinPoint.getArgs())));
    }

}
