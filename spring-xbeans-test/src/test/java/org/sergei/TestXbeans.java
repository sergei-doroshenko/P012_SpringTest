package org.sergei;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To run test in IDEA:
 * 1. configure maven-xbean-plugin in pom.xml
 * 2. run mvn clean package
 * 3. add created jar in classpath
 * e.g. '/home/sergei/projects/idea_projects/P012_SpringTest/spring-xbeans-test/target/spring-xbeans-test-1.0.jar'
 * 4. run test
 *
 * You can receive exception that app can't read schema, try to run step 2, 4 again.
 *
 * Created by sergei on 1/19/16.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})*/
public class TestXbeans {

    @Test
    public void testBeanGetsCreated() {

        // Got to use the XBean version of the Application Context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        assertEquals(1, context.getBeansOfType(SimpleBean.class).size());

        SimpleBean bean = context.getBean(SimpleBean.class);
        System.out.println(bean.getMyProperty());
        assertEquals("testMe", bean.getMyProperty());

        SimpleController controller = bean.getSimpleController();
        System.out.println(controller.getControllerName());
        assertEquals("testMeToo", controller.getControllerName());

        List<ComplexController> controllers = bean.getControllers();
        controllers.stream().map(c -> c.getPattern()).forEach(System.out::println);
        assertEquals(3, controllers.size());

    }
}
/*
Test output should be:

testMe
testMeToo
testPattern
testPattern2
testPattern3
 */
