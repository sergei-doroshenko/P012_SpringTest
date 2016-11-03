package org.sergei;

import java.util.List;

/**
 * Created by Sergei_Doroshenko on 10/17/2016.
 */
public class Result {
    private String domain;
    private List<String> names;

    public Result() {
    }

    public Result(String domain, List<String> names) {
        this.domain = domain;
        this.names = names;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Result{" +
                "domain='" + domain + '\'' +
                ", names=" + names +
                '}';
    }
}
