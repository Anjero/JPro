package net.anjero.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;


/**
 * Created by tengshaojun on 2016/6/15.
 */
public class ShortenUrl {

    private static String url = "http://api.t.sina.com.cn/short_url/shorten.json";

    private static String source =  "3034486888";

    //        String source =  PropertyUtils.value("wb.open.platform.app.key");


    /**
     * 获取url 短链接
     * @param urlLong
     * @return
     * modify  ninglei
     * datetime  2016-06-18
     * 提取 静态变量 修正url参数没有做encoding的bug
     */
    public static String getShortenUrl(String urlLong){
        String urlstr = "?source="+source +"&url_long="+urlLong;//参数做urlencoding
        String result = HttpUtil.get(url, urlstr);
        JSONArray array = JSONObject.parseArray(result);
        Map map =(Map) array.get(0);
        result = (String) map.get("url_short");
        return result;
    }


    public static String getShortenUrlWithBlank(String urlLong){
        return " "+getShortenUrl(urlLong).replace("http://","")+" ";
    }


    public static void main(String[] args) {
        System.out.println(getShortenUrlWithBlank("http://www.ichefeng.com"));
    }

}
