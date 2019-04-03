package org.sergei.bean_post_proc;

import org.sergei.inject_rnd_int.InjectRandomInt;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by sergei on 12/9/15.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestBean {
    @InjectRandomInt
    private int value1;

    @InjectRandomInt(min = 100, max = 200)
    private int value2;

    private int value3;

    @Override
    public String toString() {
        return "TestBean{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", value3=" + value3 +
                '}';
    }
}
