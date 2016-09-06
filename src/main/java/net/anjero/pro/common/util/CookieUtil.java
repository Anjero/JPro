package net.anjero.pro.common.util;

import net.anjero.pro.common.core.ApplicationListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    String domain= ApplicationListener.getCookieDomain();
  public static void setCookies(HttpServletResponse response, String key, String value) {
    try {
        String domain= ApplicationListener.getCookieDomain();
      Cookie e = new Cookie(key, value);
      e.setPath("/");
      e.setMaxAge(1296000);
        e.setDomain(domain);
      response.addCookie(e);
    } catch (Exception var4) {
      var4.printStackTrace();
    }

  }


  public static void setCookies(HttpServletResponse response, String key, String value, Integer cookiestime) {
    try {
        String domain= ApplicationListener.getCookieDomain();
      Cookie e = new Cookie(key, value);
      e.setPath("/");
      e.setMaxAge(cookiestime);
      e.setDomain(domain);
      response.addCookie(e);
    } catch (Exception var5) {
      var5.printStackTrace();
    }

  }

  public static Cookie getCookie(String name) {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      Cookie[] arr$ = cookies;
      int len$ = cookies.length;

      for (int i$ = 0; i$ < len$; ++i$) {
        Cookie c = arr$[i$];
        if (c.getName().equalsIgnoreCase(name)) {
          return c;
        }
      }
    }

    return null;
  }

  public static void clearCookie(HttpServletResponse response, String name) {
      String domain= ApplicationListener.getCookieDomain();
    Cookie cookie = new Cookie(name, (String) null);
    cookie.setMaxAge(0);
    cookie.setDomain(domain);
    cookie.setPath("/");
    response.addCookie(cookie);
  }
}