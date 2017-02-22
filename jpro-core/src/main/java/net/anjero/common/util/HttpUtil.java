package net.anjero.common.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Created by Anjero on 16/8/25.
 */
public class HttpUtil {
    private static Logger log = Logger.getLogger("sys");

    public HttpUtil() {
    }

    public static String post(String url, NameValuePair[] params) {
        String result = "";
        PostMethod method = new PostMethod(url);

        try {
            method.setRequestBody(params);
            method.getParams().setContentCharset("UTF8");
            HttpClient e = new HttpClient();
            e.executeMethod(method);
            result = method.getResponseBodyAsString();
            String var5 = result;
            return var5;
        } catch (HttpException var10) {
            log.error("http util post error", var10);
        } catch (IOException var11) {
            log.error("http util post  io error", var11);
        } finally {
            method.releaseConnection();
        }

        return null;
    }

    public static String post(String url) {
        String result = "";
        PostMethod method = new PostMethod(url);

        try {
            HttpClient e = new HttpClient();
            e.executeMethod(method);
            result = method.getResponseBodyAsString();
            String var4 = result;
            return var4;
        } catch (HttpException var9) {
            log.error("http util post error", var9);
        } catch (IOException var10) {
            log.error("http util post  io error", var10);
        } finally {
            method.releaseConnection();
        }

        return null;
    }

    public static String get(String url, String queryString) {
        String response = null;
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);

        try {
            if(!StringUtils.isEmpty(queryString)) {
                method.setQueryString(URIUtil.encodeQuery(queryString));
            }

            client.executeMethod(method);
            if(method.getStatusCode() == 200) {
                response = method.getResponseBodyAsString();
            }
        } catch (URIException var10) {
            log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", var10);
        } catch (IOException var11) {
            log.error("执行HTTP Get请求" + url + "时，发生异常！", var11);
        } finally {
            method.releaseConnection();
        }

        return response;
    }
}
