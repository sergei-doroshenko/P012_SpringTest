package org.sergei.hiber.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.sergei.hiber.domain.Delivery;
import org.sergei.hiber.domain.Order;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DeliveryDao extends HibernateDaoSupport {

    @Transactional
    public List<Order> getBySQL() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Delivery.class);
        criteria.setFetchMode("orders", FetchMode.JOIN);

//        String sql = "{alias}.status = 'COMPLETED'";
//        criteria.add(Restrictions.sqlRestriction(sql));

        return criteria.list();
    }

    @Transactional
    public void save(Delivery delivery) {
        getSessionFactory().getCurrentSession().save(delivery);
    }

}
