package net.anjero.pro.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * 
 * @Title :Utils.java
 * @Description:
 * @Datetime :2013-9-12
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 * @author :Anjero
 * @version :1.0
 */
public class Utils {

	public static final String DATE_STYLE_COMMON = "yyyy-MM-dd HH:mm:ss";

	public static class Str {
		static final char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9'};

		static final Random rand = new Random();

		public static String getValue(String str) {
			if (null == str) {
				return "";
			}
			if ("".equals(str) || "null".equals(str) || "NULL".equals(str)) {
				return "";
			}
			return str.trim();
		}
		/**
		 * 字符串转换成数字
		 * 
		 * @param str
		 *            数字形式的字符串如:"11"
		 * @return Integer 如:11
		 */
		public static int Str2Int(String str) {
			if (isEmpty(str)) {
				return 0;
			} else {
				return Integer.valueOf(str);
			}
		}
		/**
		 * 产生随机字符串
		 * 
		 * @param length
		 * @return
		 */
		static String randomNumber(int length) {
			StringBuffer sb = new StringBuffer();
			for (int loop = 0; loop < length; loop++)
				sb.append(digits[rand.nextInt(digits.length)]);
			return sb.toString();
		}

		/**
		 * 随机码
		 * 
		 * @return
		 */
		public static String getOrderNo(int n) {
			String sn = randomNumber(n);
			return sn;
		}

		/**
		 * 判空
		 * 
		 * @param
		 * @return boolean
		 */
		public static boolean isEmpty(String str) {
			return "".equals(getValue(str));
		}

		/**
		 * md5加密方法
		 * 
		 * @param plainText
		 * @return string
		 */
		public static String encodeMD5(String plainText) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(plainText.getBytes());
				byte b[] = md.digest();
				int i;
				StringBuffer buf = new StringBuffer("");
				for (int offset = 0; offset < b.length; offset++) {
					i = b[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						buf.append("0");
					buf.append(Integer.toHexString(i));
				}
				return buf.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return "";
		}
        public static String toString(String str[]) {
            String strs="";
            for(int i =0;i<str.length;i++){
                if(strs.length()>0){
                    strs+=","+str[i];
                }else{
                    strs=str[i];
                }
            }
            return  strs;
        }
	}

	public static class DateFormate {
		public static String getcurrentDatetime(String style) {
			SimpleDateFormat formatter = new SimpleDateFormat(style);
			Date currentTime = new Date();
			String currentDatetime = formatter.format(currentTime);
			return currentDatetime;
		}
		public static String getcurrentDatetime(Date currentTime, String style) {
			SimpleDateFormat formatter = new SimpleDateFormat(style);
			String currentDatetime = formatter.format(currentTime);
			return currentDatetime;
		}
		public static Date String2Date(String dateString, String style) {
			Date date = new Date();
			SimpleDateFormat strToDate = new SimpleDateFormat(style);
			try {
				date = strToDate.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
		public static final String FormatUIDate(Date date) {
			SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");
			String formatDate = time.format(date);
			return formatDate;
		}
		/**
		 * 得到几天前的时间
		 * 
		 * @param d
		 * @param day
		 * @return
		 */
		public static Date getDateBefore(Date d, int day) {
			Calendar now = Calendar.getInstance();
			now.setTime(d);
			now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
			return now.getTime();
		}
		public static final String SimpleDateFormat(Date date) {
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatDate = time.format(date);
			return formatDate;
		}

		public static final String SimpleDateUserFormat(Date date,
				String formater) {
			SimpleDateFormat time = new SimpleDateFormat(formater);
			String formatDate = time.format(date);
			return formatDate;
		}

	}
}
