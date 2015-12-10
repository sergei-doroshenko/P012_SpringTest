package org.sergei.deprecated_class;

import org.sergei.quoter.TerminatorQuoter;
import org.sergei.profiling.Profiling;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 */
@Profiling
public class T1000 extends TerminatorQuoter {

    @Override
    // throw NoSuchMethodException
//    @PostProxy
    public void sayOuote() {
        System.out.println("I'm liquid.");

    }
}
