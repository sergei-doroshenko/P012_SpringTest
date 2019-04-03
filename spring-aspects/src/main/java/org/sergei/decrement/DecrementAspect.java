package org.sergei.decrement;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by sergei on 11/23/15.
 */
@Component
@Aspect
public class DecrementAspect {

    @Around("execution(* org.sergei.decrement.IncrementService.inc(int))")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        int value = (int) pjp.proceed();
        return value - 1;
    }
}
