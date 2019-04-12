package org.sergei.trackers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class TrackerAspect {

    @Around("execution(@Tracked * org.sergei.trackers.Service01..*(..))")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("TrackerAspect: Tracking started...");
        String value = (String) pjp.proceed();

        String currentDate = DateTimeFormatter.BASIC_ISO_DATE.format(LocalDateTime.now());

        System.out.println("TrackerAspect: Tracking completed...");
        return value + ": " + currentDate;
    }
}
