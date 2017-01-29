package org.sergei.hiber.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.sergei.hiber.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergei_Doroshenko on 12/5/2016.
 */
public class OrderDao extends HibernateDaoSupport {

    @Transactional(readOnly = false)
    public Long save( Order order ) {
        Long id = ( Long ) getHibernateTemplate().save( order );
        return id;
    }

    public List<Order> findOrder( Long orderId ) {
        List<Order> orders = ( List<Order> ) getHibernateTemplate().find(" from Order o where o.id= ?", new Object[]{orderId});
        return orders;
    }

    /**
     * org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
     * @param orderId
     * @return List or Orders
     */
    @Transactional
    public List<Order> findEagerly( Long orderId, Collection<String> associations ) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Order.class);
        criteria.add(Restrictions.idEq(orderId));
        associations.stream().forEach(a -> criteria.setFetchMode(a, FetchMode.JOIN));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Transactional
    public List<Order> findEagerly( List<Long> orderIds, Collection<String> associations ) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Order.class);
        criteria.add(Restrictions.in("id", orderIds));
        associations.stream().forEach(a -> criteria.setFetchMode(a, FetchMode.JOIN));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public List<Order> findAll() {
        List<Order> orders = ( List<Order> ) getHibernateTemplate().find(" from Order ");
        return orders;
    }

    @Transactional(readOnly = false)
    public void delete ( List<Order> orders ) {
        getHibernateTemplate().deleteAll( orders );
    }

    @Transactional(readOnly = false)
    public void deleteHql ( List<Order> orders ) {
        final String hql = "delete from Order o where o.id in :orderIds";
        final List<Long> orderIds = orders.stream()
                .map( o -> o.getId() )
                .collect( Collectors.toList() );

        getHibernateTemplate().execute( new HibernateCallback() {
            @Override
            public Object doInHibernate ( Session session ) throws HibernateException {
                Query query = session.createQuery( hql );
                query.setParameterList( "orderIds", orderIds );
                return query.executeUpdate();
            }
        } );
    }

}
