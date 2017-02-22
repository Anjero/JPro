package net.anjero.common.spring;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;

/**
 * <p>jbbs Create by 15/1/4 下午3:03</p>
 *
 * @author :anjero
 * @version :1.0
 */

@Component
public class PropertyUtils {


    Logger LOG = Logger.getLogger("propertyUtils");


    private static String DAFULT_VALUE = "";

    private static Properties properties;

    @Resource(name = "configProperties")
    private Properties myProperties;

    private PropertyUtils() {

    }

    @PostConstruct
    public void init() {
        if (myProperties != null) {
            properties = myProperties;
            LOG.info("inited properties ");
        }
    }

    /**
     * 取值
     *
     * @param key
     * @return
     */
    public static String value(String key) {
        if (properties != null) {
            return properties.getProperty(key, DAFULT_VALUE);
        }
        return "";
    }
}
