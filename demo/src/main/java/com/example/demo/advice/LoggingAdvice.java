package com.example.demo.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value="execution( * com.example.demo.*.*.*(..) )")
    public void aroundPointcut() {
    }

    @Around("aroundPointcut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        ObjectMapper mapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();

        log.info(String.format("Method invoked - class name: %s, method name: %s, arguments: %s",
                className, methodName, mapper.writeValueAsString(array)));

        Object object = proceedingJoinPoint.proceed();
        
        log.info(String.format("Method invoked - class name: %s, method name: %s, return: %s",
                className, methodName, mapper.writeValueAsString(object)));

        return object;
    }

}
