package net.anjero.common.core.exception;

import com.alibaba.fastjson.JSON;
import net.anjero.plugins.json.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * wechat
 *
 * @author :anjero
 * @version :1.0
 * @Title :JsonExceptionHandlerAdapter
 * @Description:
 * @Datetime : 14/9/15 下午5:44
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 */

@Component
public class JsonHandlerExceptionResolver implements HandlerExceptionResolver {

    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger("Exception.hander");

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {


        LOG.info("JsonHandlerExceptionResolver.ex:" + ex.getClass());
        ex.printStackTrace();
        response.setCharacterEncoding("utf-8");
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        String view = "error";
        if (handlerMethod.getBean().toString().indexOf(Result.class.getPackage().getName()) > -1) {
            view = "error_json";
        }
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (ex instanceof ForbiddenJsonException) {
            Result result = new Result(403, "403:Forbidden", "登录超时");
            return new ModelAndView(view, "msg", JSON.toJSON(result));
        }
        return new ModelAndView(view, "msg", "出错啦！");
//        return null;
    }
}
