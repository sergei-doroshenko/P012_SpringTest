package org.sergei.impl;

import org.sergei.OrderDAO;
import org.sergei.domain.Order;

/**
 * Created by Sergei_Doroshenko on 10/4/2016.
 */
public class OrderDAOImpl
    implements
        OrderDAO
{

    @Override
    public Order findOrder(Long orderId) {
        return new Order( 1L, "One" );
    }
}
