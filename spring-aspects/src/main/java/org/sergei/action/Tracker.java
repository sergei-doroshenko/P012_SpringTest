package org.sergei.action;


import org.aspectj.lang.ProceedingJoinPoint;

public class Tracker {

    public boolean retunrnFalse(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Tracker plays here...");
        return false;
    }

}
