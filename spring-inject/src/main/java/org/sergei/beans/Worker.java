package org.sergei.beans;

/**
 * Created by sergei on 11/24/15.
 */
public class Worker {
    private boolean big = false;
    private int number;

    public Worker() {
        System.out.println("First constructor called");
    }

    public Worker(boolean big) {
        this.big = big;
        System.out.println("Second construction called");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        System.out.println("Setter called.");
    }

    @Override
    public String toString() {
        return "Worker{" +
                "big=" + big +
                ", number=" + number +
                '}';
    }
}
