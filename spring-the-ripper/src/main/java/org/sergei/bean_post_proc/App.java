package org.sergei.bean_post_proc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergei_Doroshenko on 12/16/2014.
 *
 *
 *
 */
public class App {
    public static void main (String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        for (int i = 0; i < 5; i++)
            System.out.println(context.getBean(TestBean.class));
    }
}
