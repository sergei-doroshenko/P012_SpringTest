package org.sergei.aop;

/**
 * Created by Sergei on 10.07.2015.
 */
public class PerformerImpl implements Performer {
    public void doSmth() {
        System.out.println(print());
    }

    public String print() {
        return "Performer is working...";
    }
}
