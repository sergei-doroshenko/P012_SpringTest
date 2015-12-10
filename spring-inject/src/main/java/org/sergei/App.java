package org.sergei;

import org.sergei.beans.Worker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergei on 11/24/15.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Worker worker = (Worker) context.getBean("worker");
        System.out.println(worker);
    }
}
