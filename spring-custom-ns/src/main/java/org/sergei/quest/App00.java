package org.sergei.quest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.List;

/**
 * Created by sergei on 1/20/16.
 */
public class App00 {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        @SuppressWarnings("unchecked")
        List<MenuItem> toplevel = (List<MenuItem>) ctx.getBean("toplevel");

        JFrame mainFrame = new JFrame();
        JMenuBar menuBar = new JMenuBar();

        for (MenuItem item: toplevel) {
            menuBar.add(item.build());
        }

        mainFrame.add(menuBar);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
