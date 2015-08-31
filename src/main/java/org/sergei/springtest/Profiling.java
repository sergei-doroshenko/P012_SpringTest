package org.sergei.springtest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 *
 * Write (on console) in log time of work of each class method
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
