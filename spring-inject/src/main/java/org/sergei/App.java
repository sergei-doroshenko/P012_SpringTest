package org.sergei;

import org.sergei.beans.ManualInjection;
import org.sergei.beans.SomeComponent;
import org.sergei.beans.Worker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Created by sergei on 11/24/15.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Worker worker = (Worker) context.getBean("worker");
        System.out.println(worker);

        SomeComponent someComponent = context.getBean(SomeComponent.class);
        System.out.println(someComponent.getName());

        ManualInjection manualInjection = new ManualInjection();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(manualInjection);
        System.out.println(manualInjection.getNameFromInjected()); // NPE
    }
}
