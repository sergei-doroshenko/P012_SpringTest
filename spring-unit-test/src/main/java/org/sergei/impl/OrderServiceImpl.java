package org.sergei.impl;

import org.sergei.OrderDAO;
import org.sergei.OrderService;
import org.sergei.domain.Order;

/**
 * Created by Sergei_Doroshenko on 10/4/2016.
 */
public class OrderServiceImpl
    implements
        OrderService
{
    private OrderDAO orderDAO;

    private boolean checkOrderId( Long orderId ) {
        return orderId % 2 == 0;
    }

    @Override
    public Order getOrder(Long orderId) {
        if ( checkOrderId( orderId) ) {
            return orderDAO.findOrder( orderId );
        }

        throw new RuntimeException("Invalid order id.");
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
