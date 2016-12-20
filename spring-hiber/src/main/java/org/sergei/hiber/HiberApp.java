package org.sergei.hiber;

import org.sergei.hiber.dao.OrderDao;
import org.sergei.hiber.domain.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Sergei_Doroshenko on 12/5/2016.
 */
public class HiberApp {

    public static void main ( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        OrderDao orderDao = context.getBean( OrderDao.class );
        List<Order> orders0 = orderDao.findOrder( 1L );
        System.out.println(orders0);
        System.out.println("----------------------------------------------------------------------------");

        Order order1 = new Order();
        order1.setDescription( "New order" );
        orderDao.save( order1 );

        List<Order> orders1 = orderDao.findAll();
        System.out.println(orders1);
        System.out.println("----------------------------------------------------------------------------");

        orderDao.delete( orders1 );

        List<Order> orders2 = orderDao.findAll();
        System.out.println(orders2);

    }
}