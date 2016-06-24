package org.sergei;

import java.util.List;

/**
 * Created by sergei_doroshenko on 6/24/2016.
 */
public class BeanWithConstructor {
    private final List<String> props;

    public BeanWithConstructor(List<String> props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "BeanWithConstructor{" +
                "props=" + props +
                '}';
    }
}
