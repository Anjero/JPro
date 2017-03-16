package net.anjero.common.core;

import net.anjero.pro.module.core.JProHelper;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class ApplicationListener implements ServletContextListener {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger("net.anjero.system");

    private static String projectPath;
    private static String cookieDomain;
    private static String fileCatalogue;

    private static String fileUrl = "/static";
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


        //初始化
        JProHelper jProHelper = (JProHelper) wac.getBean("JProhelperService");
        ApplicationConstants.setjProHelper(jProHelper);

        ApplicationConstants.setProjectPath(projectPath);


        this.setFileCatalogue(projectPath);
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
