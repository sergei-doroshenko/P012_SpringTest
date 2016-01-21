package org.sergei.quest.custom_context;

import org.sergei.quest.quoter.Quoter;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 */
public class PropertiesFileApplicationContext extends GenericApplicationContext {

    public PropertiesFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        System.out.println("loaded BeanDefinitions: " + i);
        refresh();
    }

    public static void main (String[] args){
        ApplicationContext context = new PropertiesFileApplicationContext("context.properties");
        context.getBean(Quoter.class).sayOuote();
    }
}
