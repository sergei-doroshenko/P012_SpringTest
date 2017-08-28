package org.sergei.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActionApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ActionService service = context.getBean(ActionService.class);
        ActionServiceImpl service = context.getBean(ActionServiceImpl.class);

//        System.out.println( ((Traceable) service).isAllowed("Looooooooooooooooooooooong")  );

        String result = service.doAction("Test Test Test");
        System.out.println(result);
    }
}
