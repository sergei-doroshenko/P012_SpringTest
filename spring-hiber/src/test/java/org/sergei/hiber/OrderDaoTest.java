package org.sergei.hiber;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sergei.hiber.dao.DeliveryDao;
import org.sergei.hiber.dao.OrderDao;
import org.sergei.hiber.domain.Delivery;
import org.sergei.hiber.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Sergei_Doroshenko on 12/5/2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application-context.xml"})
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DeliveryDao deliveryDao;

    @Before
    public void setUp() {
        for (int i = 0; i < 4; i++) {
            Delivery delivery = new Delivery();
            delivery.setTitle("Test Delivery");
            deliveryDao.save(delivery);

            Order order = new Order();
            order.setDelivery(delivery);
            order.setDescription("test: " + i);
            order.setStatus(Order.Status.IN_PROGRESS);
            orderDao.save(order);
        }
    }

    @Test
    public void testDeleteAll() {
        List<Order> orders = orderDao.findAll();
        orderDao.delete(orders);
    }

    @Test
    public void testDeleteHql() {
        List<Order> orders = orderDao.findAll();
        orderDao.deleteHql(orders);
    }

}
