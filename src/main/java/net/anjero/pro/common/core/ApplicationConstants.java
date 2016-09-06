package net.anjero.pro.common.core;

import net.anjero.pro.common.spring.PropertyUtils;
import org.springframework.util.StringUtils;

/**
 * weishop
 *
 * @author :anjero
 * @version :1.0
 * @Title :ApplicationConstants
 * @Description:
 * @Datetime : 14/8/19 下午3:38
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 */
public class ApplicationConstants {

    public static final String LOCAL = "local";

    static String project_path;

    /**
     * 项目名称,BaseFilter赋值
     */
    public static String BASE;

    /**
     * 项目物理路径,BaseFilter赋值
     */
    public static String PROJECT_PATH;


    public static String BASE_URL;
    public static String BASE_STATIC_URL;


    public static String getValue(String key) {
        return PropertyUtils.value(key);
    }

    /**
     * 是否为本机测试环境
     *
     * @return
     */
    public static final boolean isLocal() {
        String mode = getValue("base.mode");
        if (!StringUtils.isEmpty(mode) && mode.equals(LOCAL)) {
            return true;
        }

        return false;
    }

    //public static String baseUrl() {
    //    return getValue("base.url");
    //}
    public static String baseUrl() {
        return BASE_URL;
    }

    public static String ichefengBaseUrl() {
        return getValue("ichefeng.base.url");
    }

    public static String staticPath() {
//        return getValue("base.upload.path");
        if (project_path == null) {
            return "/var/conf";
        }
        return project_path;
    }

    public static void setProjectPath(String path) {
        project_path = path;
    }

    //public static String staticUrl() {
    //    return getValue("base.static.url");
    //}
    public static String staticUrl() {
        return getValue("base.static.url");
    }

    public static String defaultAvator() {
        return getValue("base.static.url") + "/imgs/avator.png";
    }


    public static String staticVersion() {
        return getValue("static.version");
    }

    public static String mailDev() {
        return getValue("dev.mail");
    }


    public static Integer getPageSize() {
        return Integer.valueOf(getValue("system.page.pageSize"));
    }

    public static String getFtpUrl() {
        return getValue("ftp.mno.url");
    }

    public static Integer getFtpPort() {
        return Integer.valueOf(getValue("ftp.mno.port"));
    }

    public static String getFtpName() {
        return getValue("ftp.mno.username");
    }

    public static String getFtpPass() {
        return getValue("ftp.mno.password");
    }

    public static String getMailTo() {
        return getValue("system.mail.mailto");
    }

    public static String getFileSaveMainPath(){return  getValue("photo.fileUploadPath");}

}
