package org.sergei.hiber.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Sergei_Doroshenko on 12/5/2016.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_description")
    private String description;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Tag> tags;

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                /*", tags=" + (tags == null ? "[]" : tags)  +*/
                '}';
    }
    /*
    org.hibernate.LazyInitializationException: failed to lazily initialize
    a collection of role: org.sergei.hiber.domain.Order.tags,
    could not initialize proxy - no Session
     */
}
