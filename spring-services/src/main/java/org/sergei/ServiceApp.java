package org.sergei;

import org.sergei.service.MainService;
import org.sergei.service.Strategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Sergei_Doroshenko on 5/5/2016.
 */
public class ServiceApp {
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--------------------------------------------------------------");
        List<Strategy> list = (List) context.getBean("sList");
        list.forEach(s -> System.out.println( s.getName() ));
        System.out.println("--------------------------------------------------------------");

        MainService service = context.getBean(MainService.class);

        System.out.println( service.getStrategy( "UserStrategy" ).getName() );
        System.out.println( service.getStrategy( "TaskStrategy" ).getName() );
        System.out.println( service.getStrategy( "AccountStrategy" ).getName() );

    }
}
