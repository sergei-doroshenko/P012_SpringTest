package org.sergei;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Sergei_Doroshenko on 1/20/2017.
 */

@Configuration
public class ModelUtilTestConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        Properties properties = new Properties();
        properties.setProperty("url.validator.on", "true");
        properties.setProperty("url.validator.max.length", "100");
        pspc.setProperties(properties);
        return pspc;
    }

    @Bean
    public ModelUtil getDataModelUtil() {
        return null;
    }
}
