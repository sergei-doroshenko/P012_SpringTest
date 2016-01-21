package org.sergei.quest.logit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergei on 11/23/15.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestForLogger test = (TestForLogger)context.getBean("testForLogger");
        test.get();
    }
}
