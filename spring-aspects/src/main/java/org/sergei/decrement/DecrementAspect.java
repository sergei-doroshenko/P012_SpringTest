package org.sergei.decrement;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by sergei on 11/23/15.
 */
@Component
@Aspect
public class DecrementAspect {

    private volatile int counter = 0;

    @Pointcut("execution(* org.sergei.decrement.IncrementService.inc(..))")
    public void incrementMethod(){}

    @Pointcut("execution(* org.sergei.decrement.IncrementService.send(..))")
    public void sendMethod(){}

//    @Around("execution(* org.sergei.decrement.IncrementService.inc(int))")
    @Around("incrementMethod()")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        int value = (int) pjp.proceed();
        System.out.println("Aspect fired");
        return value - 1;
    }

    @Around("incrementMethod() || sendMethod()")
    public Object countAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Count Aspect fired: " + ++counter);
        return pjp.proceed();
    }
}
