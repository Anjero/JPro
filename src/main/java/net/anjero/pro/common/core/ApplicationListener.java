package net.anjero.pro.common.core;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class ApplicationListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger("system");

    private static String projectPath;
    private static String cookieDomain;
    private static String fileCatalogue;

    private static String fileUrl;
    private static String wxUrl;
    public void contextDestroyed(ServletContextEvent event) {

    }
    public static String getCookieDomain() {
        return cookieDomain;
    }

    public static void setCookieDomain(String cookieDomain) {
        ApplicationListener.cookieDomain = cookieDomain;
    }

    public static String getFileCatalogue() {
        return fileCatalogue;
    }

    public static void setFileCatalogue(String fileCatalogue) {
        ApplicationListener.fileCatalogue = fileCatalogue;
    }

    public static String getFileUrl() {
        return fileUrl;
    }

    public static void setFileUrl(String fileUrl) {
        ApplicationListener.fileUrl = fileUrl;
    }

    public static String getWxUrl() {
        return wxUrl;
    }


    public void contextInitialized(ServletContextEvent event) {

        WebApplicationContext wac = WebApplicationContextUtils
                .getRequiredWebApplicationContext(event.getServletContext());
        // 初始化系统环境变量
        this.projectPath = event.getServletContext().getRealPath("/");

        ApplicationConstants.setProjectPath(projectPath);
        LOG.info("start init system");
        LOG.info("1.init sysprovince config");
        LOG.info("=============System=================");
        LOG.info("inited system config...");
        LOG.info("JPro WEBSERVER STARTED!!!");
        LOG.info("====================================");
    }

    /**
     * 得到工程绝对路径
     *
     * @return
     */
    public static String getProjectPath() {
        return projectPath;
    }

}
