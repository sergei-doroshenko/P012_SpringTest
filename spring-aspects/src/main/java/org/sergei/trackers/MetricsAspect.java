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
@Order(Ordered.HIGHEST_PRECEDENCE + 100)
@Component
public class MetricsAspect {

    @Around("execution(@Metrics * org.sergei.trackers.Service01..*(..))")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        LocalDateTime start = LocalDateTime.now();

        Object value = pjp.proceed();

        LocalDateTime end = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String message = String.format("MetricsAspect: Operation started at: %s, finished at: %s, duration: %s",
                formatter.format(start), formatter.format(end), "test");
        System.out.println(message);

        return value;
    }
}
