package net.anjero.plugins.velocity;


import net.anjero.common.core.ApplicationConstants;
import net.anjero.pro.module.classify.pojo.Classify;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author :anjero
 * @version :1.0
 * @Title :VelocityUtils.java
 * @Description:
 * @Datetime : 2014-5-30 下午5:29
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 */

public class VelocityUtils {

    public static String url() throws UnsupportedEncodingException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String url = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort();
        url = url + request.getRequestURI();
        if (url.indexOf("/login") > 0) {
            url = url.replace("/login", "/");
        }
        return URLEncoder.encode(url, "UTF-8");
    }


    public static String staticUrl(String path) {
        return ApplicationConstants.staticUrl() + path;
    }

    public static String staticUrl() {
        return ApplicationConstants.staticUrl();
    }

    public static String baseUrl() {
        return ApplicationConstants.baseUrl();
    }

    public static String staticVersion() {
        return ApplicationConstants.staticVersion();
    }

    public static String devMail() {
        return ApplicationConstants.mailDev();
    }

    public static String managerProjectName() {
        return ApplicationConstants.getValue("manager.project.name");
    }

    public static String company() {
        return ApplicationConstants.getValue("manager.company");
    }


    public static List<Classify> classifies() {
        List<Classify> classifies = ApplicationConstants.getjProHelper().selectClassifies();
        return classifies;
    }

    public static List<Classify> selectClassifiesNoSys() {
        return ApplicationConstants.getjProHelper().selectClassifiesNoSys();
    }

    public static Classify footer() {
        Classify classify = ApplicationConstants.getjProHelper().footer();
        return classify;
    }
}
