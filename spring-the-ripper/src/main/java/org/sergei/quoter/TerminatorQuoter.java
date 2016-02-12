package org.sergei.quoter;

import org.sergei.context_listener.PostProxy;
import org.sergei.inject_rnd_int.InjectRandomInt;
import org.sergei.profiling.Profiling;

import javax.annotation.PostConstruct;

/**
 * Created by Sergei_Doroshenko on 12/16/2014.
 *
 * https://www.youtube.com/watch?v=cou_qomYLNU - part 2
 */

@Profiling
//@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1 - call constructor.");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase 2 - init method.");
        System.out.println("repeat: " + repeat);
        //sayOuote();
    }

    // call by reflection
    public void setMessage(String message) {
        this.message = message;
    }

    // also need to call by reflection
    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @Override
    @PostProxy
    public void sayOuote() {
        System.out.println("Phase 3 - context listener.");
        for (int i = 0; i < repeat; i++){
            System.out.println("message: " + message);
        }

    }
}
