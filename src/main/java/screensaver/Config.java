package screensaver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 */
@Configuration
@ComponentScan(basePackages = "screensaver")
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
            @Override
            protected Color getColor() {
                return color(); // look up method
            }
        };
    }

    public static void main (String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true){
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(300);
        }
    }
}
