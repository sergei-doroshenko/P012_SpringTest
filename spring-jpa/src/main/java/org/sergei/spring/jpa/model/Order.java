package org.sergei.spring.jpa.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;

/**
 * Created by Sergei_Doroshenko on 1/23/2017.
 */
@Entity
public class Order {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", nullable = false)
    private String orderTags;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @BatchSize(size = 100)
    private List<String> runTags = new ArrayList<>();

    /* for future OrderDao
    public T fetchEagerlyById(PK id, Collection<String> associations) {
        Criteria criteria = getSession().createCriteria(type);
        criteria.add(Restrictions.eq("id", id));
        for (String association : associations) {
            criteria.setFetchMode(association, FetchMode.JOIN);
        }
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (T) criteria.uniqueResult();
    }

    and in Service:
    @Transactional(readOnly = true)
    @Override
    public T getByID(PK id, List<String> associations) {
        return getRepository().fetchEagerlyById(id, associations);
    }

    and in Controller:
    Order order = orderService.getByID( orderId,
        ImmutableList.of(OrderMeta.campaign, OrderMeta.campaign().campaignMaps().toString(), OrderMeta.campaignMap, OrderMeta.campaignMap()
           .campaign().toString(), OrderMeta.orderTags));

     */
}
