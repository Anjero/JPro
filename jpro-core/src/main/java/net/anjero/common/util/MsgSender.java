package net.anjero.common.util;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

/**
 * 手机验证码发送
 *
 * @author :anjero
 * @version :1.0
 * @Title :MsgSender.java
 * @Description:
 * @Datetime : 2014-5-9 下午2:20
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 */

public class MsgSender {

    static Logger LOG = Logger.getLogger("notification");

    /**
     * 发送短信
     *
     * @return
     */
    public static String sender(String phone, String message) {

        String num = RandomStringUtils.randomNumeric(4);
        LOG.info("the phone:" + phone + "the msg code is :" + num);
        return num;
    }

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            System.out.println(RandomStringUtils.randomNumeric(4));
            if (++i >= 1000) {
                return;
            }
        }
    }
}
