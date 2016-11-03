package org.sergei.scheduled;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by Sergei_Doroshenko on 11/3/2016.
 */
public class ServiceFixedDelay {

    @Scheduled(fixedDelay = 5000)
    //@Scheduled(fixedRate = 5000)
    public void demoServiceMethod()
    {
        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
    }
}
