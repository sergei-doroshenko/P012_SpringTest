package org.sergei.logit;

/**
 * Created by sergei on 11/23/15.
 */
public class TestForLogger {

    @LogIt
    public void get() {
        System.out.println("Call get() on TestForLogger");
    }
}
