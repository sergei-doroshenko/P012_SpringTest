package org.sergei.hiber;

import org.sergei.hiber.dao.OrderDao;
import org.sergei.hiber.domain.Delivery;
import org.sergei.hiber.domain.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
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
        System.out.println("Find eagerly by id:");
        List<Order> orders01 = orderDao.findEagerly(1L, Arrays.asList("delivery", "tags"));
        System.out.println("Orders: " + orders01);
        orders01.stream().forEach(o -> System.out.println(o.getTags()));
        System.out.println("----------------------------------------------------------------------------");

        Order order1 = new Order();
        order1.setDescription( "New order" );
        Delivery delivery = new Delivery();
        delivery.setId(1L);
        order1.setDelivery(delivery);
        orderDao.save( order1 );

        List<Order> orders1 = orderDao.findAll();
        System.out.println(orders1);
        List<Order> orders11 = orderDao.findEagerly(Arrays.asList(1L, 2L, 3L),  Arrays.asList("delivery", "tags"));
        System.out.println(orders11);
        System.out.println("----------------------------------------------------------------------------");

        orderDao.delete( orders1 );

        List<Order> orders2 = orderDao.findAll();
        System.out.println(orders2);

    }
}
