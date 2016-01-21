package org.sergei.quest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergei on 10.07.2015.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Performer performer = (Performer)context.getBean("performerBean");
        performer.doSmth();

        Performer worker = (Performer)context.getBean("workerBean");
        worker.doSmth();
    }
}
