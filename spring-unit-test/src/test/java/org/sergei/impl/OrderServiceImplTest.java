package org.sergei.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.sergei.OrderDAO;
import org.sergei.domain.Order;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

/**
 * Created by Sergei_Doroshenko on 10/4/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(OrderServiceImpl.class)
public class OrderServiceImplTest {
    // even number
    public static final Long VALID_ORDER_ID = 20L;
    // odd number
    public static final Long INVALID_ORDER_ID = 21L;

    @Test
    public void getOrderTest_validId() throws Exception {
        // Mock DAO
        OrderDAO orderDAO = mock( OrderDAO.class );
        when( orderDAO.findOrder( anyLong() ) )
                .thenReturn( new Order( 100L, "TEST") );

        // Mock Service
        OrderServiceImpl orderServiceSpy = PowerMockito.spy( new OrderServiceImpl() );

        orderServiceSpy.setOrderDAO( orderDAO );

        orderServiceSpy.getOrder( VALID_ORDER_ID );

        PowerMockito.verifyPrivate( orderServiceSpy, times(1) ).invoke( "checkOrderId", anyLong() );
        verify( orderDAO, times(1) ).findOrder( anyLong() );
    }

    @Test(expected = RuntimeException.class)
    public void getOrderTest_invalidId() throws Exception {
        // Mock DAO
        OrderDAO orderDAO = mock( OrderDAO.class );
        when( orderDAO.findOrder( anyLong() ) )
                .thenReturn( new Order( 100L, "TEST") );

        // Mock Service
        OrderServiceImpl orderServiceSpy = PowerMockito.spy( new OrderServiceImpl() );

        orderServiceSpy.setOrderDAO( orderDAO );

        orderServiceSpy.getOrder( INVALID_ORDER_ID );

        PowerMockito.verifyPrivate( orderServiceSpy, times(3) ).invoke( "checkOrderId", anyLong() ); // doesn't check
        verify( orderDAO, times(1) ).findOrder( anyLong() ); // doesn't check
    }

    @Test
    public void getOrderTest_validId_mocked() throws Exception {
        // Mock DAO
        OrderDAO orderDAO = mock( OrderDAO.class );
        when( orderDAO.findOrder( anyLong() ) )
                .thenReturn( new Order( 100L, "TEST") );

        // Mock Service
        OrderServiceImpl orderServiceSpy = PowerMockito.spy( new OrderServiceImpl() );
        // Mock private method to return always true
        PowerMockito.when( orderServiceSpy, method( OrderServiceImpl.class, "checkOrderId", Long.class ) )
                .withArguments( any(Long.class) )
                .thenReturn( true );

        orderServiceSpy.setOrderDAO( orderDAO );

        orderServiceSpy.getOrder( INVALID_ORDER_ID ); // pass invalid order id, but receive true.

        // verify that private and public method was invoked
        PowerMockito.verifyPrivate( orderServiceSpy, times(1) ).invoke( "checkOrderId", anyLong() );
        verify( orderDAO, times(1) ).findOrder( anyLong() );
    }
}
