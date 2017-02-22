package net.anjero.common.spring.controller;


import net.anjero.common.constant.DefaultStringSerializer;
import net.anjero.common.core.exception.ForbiddenJsonException;
import net.anjero.common.util.Constants;
import net.anjero.pro.module.security.core.UserExtend;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :Anjero
 * @version :1.0
 * @Title :BaseAdminController.java
 * @Description:
 * @Datetime :2013-8-23
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 */
@Controller
public class BaseAdminController extends BaseController {



    public UserExtend getAdmin() throws ForbiddenJsonException {
        return (UserExtend) adminUser();
    }

    public Integer getAdminId() throws ForbiddenJsonException {
        if (getAdmin() != null) {
            return getAdmin().getId();
        }
        throw new ForbiddenJsonException("未登录或超时，请重新登录！");
    }

    public String getAdminName() throws ForbiddenJsonException {
        if (getAdmin() != null) {
            return getAdmin().getRealName();
        }
        throw new ForbiddenJsonException("未登录或超时，请重新登录！");
    }


    public UserDetails adminUser() throws ForbiddenJsonException {
        try {
            UserExtend userExtend = (UserExtend) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userExtend;
        } catch (Exception e) {
            throw new ForbiddenJsonException("未登录或超时，请重新登录！");
        }
    }

    protected void returnJson(Object object, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        if (StringUtils.isEmpty(callback)) {
            json(object, response);
        } else {
            jsonp(object, response, callback);
        }


    }

    /**
     * jackson转换json
     *
     * @param object
     * @param response
     */
    public void returnJson(Object object, HttpServletResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            mapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            response.setContentType("text/html;charset=UTF-8");
            mapper.writeValue(response.getWriter(), object);
        } catch (JsonGenerationException e1) {
            e1.printStackTrace();
        } catch (JsonMappingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * jackson转换json
     *
     * @param object
     * @param response
     */
    private void json(Object object, HttpServletResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.setDateFormat(new SimpleDateFormat(Constants.DATETIME_FORMAT));
            mapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

            mapper.getSerializerProvider().setNullValueSerializer(new DefaultStringSerializer());

            response.setContentType("text/json;charset=UTF-8");
            mapper.writeValue(response.getWriter(), object);
            //log.debug(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
        } catch (JsonGenerationException e1) {
            e1.printStackTrace();
        } catch (JsonMappingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * jackson转换json
     *
     * @param object
     * @param response
     */
    private void jsonp(Object object, HttpServletResponse response, String callback) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.setDateFormat(new SimpleDateFormat(Constants.DATETIME_FORMAT));
            mapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);

            mapper.getSerializerProvider().setNullValueSerializer(new DefaultStringSerializer());

            response.setContentType("text/json;charset=UTF-8");
            mapper.writeValue(response.getWriter(), new JSONPObject(callback, object));
            //log.debug(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));DefaultStringSerializer
        } catch (JsonGenerationException e1) {
            e1.printStackTrace();
        } catch (JsonMappingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static String getcurrentDatetime(String style) {
        SimpleDateFormat formatter = new SimpleDateFormat(style);
        Date currentTime = new Date();
        String currentDatetime = formatter.format(currentTime);
        return currentDatetime;
    }

}
