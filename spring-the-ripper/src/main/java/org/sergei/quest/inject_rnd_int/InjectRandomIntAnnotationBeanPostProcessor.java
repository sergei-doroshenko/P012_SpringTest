package org.sergei.quest.inject_rnd_int;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Sergei_Doroshenko on 12/16/2014.
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(InjectRandomIntAnnotationBeanPostProcessor.class);

    // call before init-method
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("postProcessBeforeInitialization::beanName = {}, beanClass = {}", beanName, bean.getClass().getSimpleName());

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields){
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null){
                int min = annotation.min();
                int max = annotation.max();

                // nextInt is normally exclusive of the top value,
                // so add 1 to make it inclusive
                Random random = new Random();
                int i = random.nextInt((max - min) + 1) + min;

                field.setAccessible(true);
                // try catch
                //field.set(i);
                ReflectionUtils.setField(field, bean, i);
            }
        }
        return bean;
    }

    // call after init-method
    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
}
