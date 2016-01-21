package org.sergei.quest.aop;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Created by Sergei on 10.07.2015.
 */
public class Aspect {
    private Logger logger;

    public void addAppender(){
        logger = Logger.getRootLogger();
        logger.setLevel(Level.INFO);
        PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
        logger.addAppender(new ConsoleAppender(layout));
    }
    public void before(){
        logger.info("Before method...");
    }
    public void after(){
        logger.info("After method...");
    }
    public void afterReturning(){
        logger.info("After returning...");
    }
    public void afterThrowing(){
        logger.error("After throwing...");
    }
}
