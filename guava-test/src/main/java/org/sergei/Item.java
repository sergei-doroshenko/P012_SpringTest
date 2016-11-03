package org.sergei;

/**
 * Created by Sergei_Doroshenko on 10/17/2016.
 */
public class Item {
    private Long id;
    private String name;
    private String domain;

    public Item(Long id, String name, String domain) {
        this.id = id;
        this.name = name;
        this.domain = domain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
