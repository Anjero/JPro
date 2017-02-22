package net.anjero.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by puqingwen on 2016/1/4.
 */
public class SpringUtil {
    public static ApplicationContext context = new ClassPathXmlApplicationContext(
        "META-INF/spring/applicationContext-honeycomb-app-database.xml");

    public static Object getBean(String serviceName){
        return context.getBean(serviceName);
    }
}
