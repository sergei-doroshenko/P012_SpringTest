package org.sergei.logit;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created by sergei on 11/23/15.
 */
public class LogInterceptor implements MethodInterceptor, Serializable {
    private Logger logger;

    public void addAppender(){
        logger = Logger.getLogger(getClass());
        logger.setLevel(Level.TRACE);
//        PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
//        logger.addAppender(new ConsoleAppender(layout));
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        String invocationDescription = getInvocationDescription(invocation);
        logger.warn("Entering " + invocationDescription);
        try {
            Object rval = invocation.proceed();
            logger.trace("Exiting " + invocationDescription);
            return rval;
        } catch (Throwable ex) {
            logger.trace("Exception thrown in " + invocationDescription, ex);
            throw ex;
        }
    }

    /**
     * Return a description for the given method invocation.
     * @param invocation the invocation to describe
     * @return the description
     */
    protected String getInvocationDescription(MethodInvocation invocation) {
        return "method '" + invocation.getMethod().getName() + "' of class [" +
                invocation.getThis().getClass().getName() + "]";
    }
}
