package org.sergei.quest.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 */
@Configuration
@ComponentScan(basePackages = "org.sergei.screensaver")
public class Config {

    @Bean
    // proxyMode = ScopedProxyMode.TARGET_CLASS for update protorype in sigleton
    //@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    //@Scope(value = "prototype")
    @Scope(value = "periodical")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            // look up method
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
}
