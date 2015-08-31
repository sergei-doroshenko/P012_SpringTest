package org.sergei.springtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergei_Doroshenko on 12/16/2014.
 *
 * video - https://www.youtube.com/watch?v=BmBr5diz8WA - part 1
 * 
 */
public class Main {
    public static void main (String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        while (true) {
            Thread.sleep(500);
            context.getBean(Quoter.class).sayOuote();
        }


    }
}
