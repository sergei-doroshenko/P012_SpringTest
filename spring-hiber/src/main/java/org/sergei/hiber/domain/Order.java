package org.sergei.hiber.domain;




import javax.persistence.*;

/**
 * Created by Sergei_Doroshenko on 12/5/2016.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_description")
    private String description;

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

    @Override
    public String toString () {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
