package org.sergei;

import org.sergei.domain.Order;

/**
 * Created by Sergei_Doroshenko on 10/4/2016.
 */
public interface OrderService {
    Order getOrder( Long orderId );
}
