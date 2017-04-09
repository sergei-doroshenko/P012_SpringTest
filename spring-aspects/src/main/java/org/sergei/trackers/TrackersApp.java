package org.sergei.trackers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TrackersApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Service01 service01 = context.getBean(Service01.class);
        String message = service01.getMessage();
        System.out.println(message);

        System.out.println(service01.getAnotherMessage());

        System.out.println(service01.getBullShit());
    }
}
