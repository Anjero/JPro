package net.anjero.common.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 记录历史指数记录
 * Created by xionghui on 2016/4/6.
 */
public class HistoryTrendUtils {

    private static Integer maxSize = 30;
    private static String format = "yyyy-MM-dd";

    /**
     * 记录历史指数记录，不填充缺失值
     * @param json
     * @param exponent
     * @param dateStr
     * @param timeFormat
     * @return
     * @throws Exception
     */
    public static String historyTrend(String json, Integer exponent, String dateStr, String timeFormat) throws Exception{
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(timeFormat);
        DateTime dateTime = DateTime.parse(dateStr, dateTimeFormatter);
        Date date = dateTime.toDate();
        return historyTrend(json, exponent, date, false);
    }

    /**
     * 记录历史指数记录，填充缺失值
     * @param json
     * @param exponent
     * @param dateStr
     * @param timeFormat
     * @return
     * @throws Exception
     */
    public static String historyTrendIsZero(String json, Integer exponent, String dateStr, String timeFormat) throws Exception{
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(timeFormat);
        DateTime dateTime = DateTime.parse(dateStr, dateTimeFormatter);
        Date date = dateTime.toDate();
        return historyTrend(json, exponent, date, true);
    }

    public static String historyTrend(String json, Integer exponent, Date date, Boolean isZero) throws Exception {
        if(StringUtils.isBlank(json)) json = "{}";
        SortedMap<String, Integer> jsonMap = JSON.parseObject(json, new TypeReference<TreeMap<String, Integer>>() {
        });
        SortedMap<String, Integer> sortedMap = new TreeMap<String, Integer>();
        DateTime dateTime = new DateTime(date);
        sortedMap.put(dateTime.toString(format), exponent);
        int n = maxSize - 1;
        while (n > 0) {
            String day = dateTime.plusDays(-n).toString(format);
            Integer value = jsonMap.get(day);
            if (value == null){
                if (isZero) sortedMap.put(day, 0);
            }else {
                sortedMap.put(day, value);
            }
            n--;
        }
        return JSONObject.toJSONString(sortedMap);
    }

    public static void main(String[] args) throws Exception{
        String json = "{\"2017-04-01\":10,\"2016-04-02\":15,\"2016-04-03\":9,\"2016-04-08\":50}";
        String dateStr = "2016-04-09 03:27:39";
        String timeFormat = "yyyy-MM-dd HH:mm:ss";
        Integer exponent = 60;
        String rs = historyTrend(json, exponent, dateStr, timeFormat);
        System.out.println(rs);

    }
}
