package org.sergei.injectproperty.injector;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by sergei on 3/18/16.
 */
@Component
public class PropertyProducer implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields){
            Property annotation = field.getAnnotation(Property.class);
            if (annotation != null){
                String key = annotation.value();

                Properties properties = new Properties();
                final InputStream stream = PropertyProducer.class
                        .getResourceAsStream("/application.properties");
                if (stream == null) {
                    throw new RuntimeException("No properties!!!");
                }
                try {
                    properties.load(stream);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, properties.getProperty(key));

                } catch (final IOException e) {
                    throw new RuntimeException("Configuration could not be loaded!");
                }
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
