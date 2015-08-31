package org.sergei.springtest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 */
public class ProfingHandlerBeanPostProcessor implements BeanPostProcessor {
    // Name of bean is always the same
    private Map<String, Class> map = new HashMap<String, Class>();
    private ProfilingController controller = new ProfilingController();

    public ProfingHandlerBeanPostProcessor() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)){
            map.put(beanName, beanClass);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null){
            // Create object from new class which generates on fly
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            // If controller ...
                            if (controller.isEnabled()) {
                                System.out.println("Profiling...");
                                long start = System.nanoTime();
                                Object retVal = method.invoke(bean, args);
                                long finish = System.nanoTime();
                                System.out.println(finish - start);
                                System.out.println("Finish...");
                                return retVal;
                            } else {
                                return method.invoke(bean, args);
                            }
                        }
                    });
        }

        return bean;
    }
}
