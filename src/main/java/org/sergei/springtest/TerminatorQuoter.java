package org.sergei.springtest;

import javax.annotation.PostConstruct;

/**
 * Created by Sergei_Doroshenko on 12/16/2014.
 *
 * https://www.youtube.com/watch?v=cou_qomYLNU - part 2
 */

@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
        //sayOuote();
    }

    // call by reflection
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayOuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++){
            System.out.println(message);
        }

    }
}
