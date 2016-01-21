package org.sergei.quest.quoter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergei_Doroshenko on 12/16/2014.
 *
 * video - https://www.youtube.com/watch?v=BmBr5diz8WA - part 1
 * https://www.youtube.com/watch?v=cou_qomYLNU - part 2
 *
 *
 * for monitoring VisualVM - current java process - plugins - Visual-MBeans - MBeans -
 */
public class App {
    public static void main (String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        while (true) {
            Thread.sleep(500);
            context.getBean(Quoter.class).sayOuote();
        }
        /*int i = 0;
        while (i++ < 1) {
            Thread.sleep(500);
            context.getBean(Quoter.class).sayOuote();
        }*/


    }
}
