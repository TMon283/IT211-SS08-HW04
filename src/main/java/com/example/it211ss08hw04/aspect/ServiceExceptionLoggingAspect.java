package com.example.it211ss08hw04.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceExceptionLoggingAspect {

    @AfterThrowing(pointcut = "execution(* com.example.it211ss08hw04.service..*(..))", throwing = "ex")
    public void logServiceExceptions(JoinPoint joinPoint, Exception ex) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.err.println("[ERROR] " + className + "." + methodName + " - " + ex.getMessage());
    }
}
