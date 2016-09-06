package net.anjero.pro.common.util;



import net.anjero.pro.common.core.ApplicationConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by puqingwen on 2016/2/17.
 */
public class ParsePaginationExtend  {

    private Map<String, String> cookieMap = new HashMap();
    private int pageSize = ApplicationConstants.getPageSize();
    private int pageNo = 1;

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageNo() {
        return this.pageNo < 1?1:this.pageNo;
    }

    public ParsePaginationExtend(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            this.parseCookies(cookies);
        }

        String pageSize = request.getParameter("pageSize");
        String page = request.getParameter("pageNo");
        String cookiePageSize = (String)this.cookieMap.get("pageSize");
        String cookiePage = (String)this.cookieMap.get("pageNo");
        HttpSession session = request.getSession();
        String sessionPage = (String)session.getAttribute("pageNo");
        String sessionPageSize = (String)session.getAttribute("pageSize");
        if(pageSize != null) {
            this.pageSize = Integer.parseInt(pageSize);
        } else if(cookiePageSize != null) {
            this.pageSize = Integer.parseInt(cookiePageSize);
        } else if(sessionPageSize != null) {
            this.pageSize = Integer.parseInt(sessionPageSize);
        }

        if(page != null) {
            this.pageNo = Integer.parseInt(page);
        } else if(cookiePage != null) {
            this.pageNo = Integer.parseInt(cookiePage);
        } else if(sessionPage != null) {
            this.pageNo = Integer.parseInt(sessionPage);
        }

    }

    private void parseCookies(Cookie[] cookies) {
        Cookie[] arr$ = cookies;
        int len$ = cookies.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Cookie cookie = arr$[i$];
            this.cookieMap.put(cookie.getName(), cookie.getValue());
        }

    }

    public String getCookieByName(String name) {
        return (String)this.cookieMap.get(name);
    }

}
