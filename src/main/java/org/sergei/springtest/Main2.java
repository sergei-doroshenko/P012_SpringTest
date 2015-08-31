package org.sergei.springtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergei_Doroshenko on 12/16/2014.
 *
 * video:
 *  https://www.youtube.com/watch?v=BmBr5diz8WA - part 1
 * https://www.youtube.com/watch?v=cou_qomYLNU - part 2
 *
 */
public class Main2 {
    public static void main (String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");


            //context.getBean(Quoter.class).sayOuote();



    }
}
