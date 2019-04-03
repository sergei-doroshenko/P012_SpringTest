package org.sergei.injectproperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergei on 3/18/16.
 */
public class AppPropertyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(context.getBean(MyInjectTestBean.class));
    }
}
