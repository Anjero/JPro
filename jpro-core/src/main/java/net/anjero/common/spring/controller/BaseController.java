package net.anjero.common.spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import net.anjero.plugins.json.Result;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import com.ichefeng.data.module.agency.pojo.AgencyUser;
//import com.ichefeng.data.module.agency.pojo.AgencyUserToken;
//import com.ichefeng.data.module.agency.service.AgencyUserService;
//import com.ichefeng.data.module.agency.service.AgencyUserTokenService;


/**
 * @author :Anjero
 * @version :1.0
 * @Title :BaseController.java
 * @Description:
 * @Datetime :2013-8-29
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 */
public class BaseController implements Serializable {

//    @Resource
//    private AgencyUserTokenService agencyUserTokenService;
//    @Resource
//    private AgencyUserService agencyUserService;

    public static final String REDIRECT = "redirect:";
    private static final long serialVersionUID = 7544640703613411536L;

    /**
     * 控制器LOG
     */
    protected Logger LOG = Logger.getLogger("controller");

    /**
     * 用户session
     */
    public static final String SESSION_ADMIN = "session_admin";

    public static final String SESSEION_USER = "sesseion_user";

    public static final String WECHAT_USER_SESSION = "wechat_user_session";

    public static final String SESSEION_PRO = "sesseion_province";

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    protected String success(Integer code, Object obj, String desc, PropertyFilter filter) {
        Result result = new Result();
        result.setCode(code);
        result.setDescription(desc);
        result.setResult(obj);
        try {

            /*
            QuoteFieldNames———-输出key时是否使用双引号,默认为true
            WriteMapNullValue——–是否输出值为null的字段,默认为false
            WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
            WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
            WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
            WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
             */

            SerializerFeature[] serializerFeatures = {SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullBooleanAsFalse};

            SerializeConfig serializeConfig = new SerializeConfig();
            serializeConfig.put(Date.class, new SimpleDateFormatSerializer(DEFAULT_PATTERN));
            return JSON.toJSONString(result, filter, serializerFeatures);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String success(Integer code, Object obj, String desc) {
        return success(code, obj, desc, null);
    }

    protected String redirect(String location) {
        return REDIRECT + location;
    }

    protected String success() {
        return success(200, null, "success", null);
    }

    protected Map<String, String> error() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("code", "201");
        return map;
    }

    protected String error(String message) {
        Result result = new Result();
        result.setCode(201);
        result.setResult(null);
        result.setDescription(message);
        try {
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    protected HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }


    protected void printWriterJSON(HttpServletResponse response, String result) {
        response.setContentType("application/x-json;charset=UTF-8");
        //response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.println(result);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
