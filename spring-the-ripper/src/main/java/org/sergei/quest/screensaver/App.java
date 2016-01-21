package org.sergei.quest.screensaver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sergei on 12/9/15.
 */
public class App {
    public static void main (String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true){
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(300);
        }
    }
}
