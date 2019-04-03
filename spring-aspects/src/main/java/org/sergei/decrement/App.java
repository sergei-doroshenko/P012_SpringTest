package org.sergei.decrement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergei on 11/23/15.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IncrementService service = context.getBean(IncrementService.class);
        System.out.println("service.inc(10): " + service.inc(10));
    }
}
