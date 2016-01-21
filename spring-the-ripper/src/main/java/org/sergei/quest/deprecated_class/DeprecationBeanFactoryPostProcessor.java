package org.sergei.quest.deprecated_class;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.annotation.Annotation;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 */
public class DeprecationBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            try {
                Class beanClass = Class.forName(beanClassName);
                Annotation annotation = beanClass.getAnnotation(DeprecatedClass.class);
                if (annotation != null){
                    beanDefinition.setBeanClassName( ((DeprecatedClass) annotation).newImpl().getName() );
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
