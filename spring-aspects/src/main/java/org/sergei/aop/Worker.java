package org.sergei.aop;

/**
 * Created by Sergei on 10.07.2015.
 */
public class Worker implements Performer {

    public void doSmth() {
        System.out.println(print());
    }

    public String print() {
        if(Math.random() < 0.5)
            throw new RuntimeException("Worker exception");
        return "Worker is working...";
    }
}
