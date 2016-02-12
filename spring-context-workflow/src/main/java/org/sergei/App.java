package org.sergei;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergei on 12/10/15.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        BeanA beanA = context.getBean(BeanA.class);

        BeanB beanB = context.getBean(BeanB.class);

        System.out.println(beanA);
        System.out.println(beanB);
    }
}
