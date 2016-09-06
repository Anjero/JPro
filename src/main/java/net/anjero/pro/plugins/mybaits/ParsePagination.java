package net.anjero.pro.plugins.mybaits;

import org.apache.commons.lang.text.StrBuilder;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ParsePagination {

    private Map<String, String> cookieMap;
    private int pageSize = 10;
    private int pageNo = 1;
    private String sortname;
    private String sortorder;

    public String getSortname() {
        return sortname;
    }

    public String getSortorder() {
        return sortorder;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo < 1 ? 1 : pageNo;
    }

    public ParsePagination() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        cookieMap = new HashMap<String, String>();

        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            parseCookies(cookies);

        String pageSize = request.getParameter("pageSize");
        String page = request.getParameter("pageNo");
        String sortname = request.getParameter("sortname");
        String sortorder = request.getParameter("sortorder");

        String cookiePageSize = cookieMap.get("pageSize");
        String cookiePage = cookieMap.get("pageNo");

        HttpSession session = request.getSession();

        String sessionPage = (String) session.getAttribute("pageNo");
        String sessionPageSize = (String) session.getAttribute("pageSize");


        if (pageSize != null) {
            this.pageSize = Integer.parseInt(pageSize);
        } else if (cookiePageSize != null) {
            this.pageSize = Integer.parseInt(cookiePageSize);
        } else if (sessionPageSize != null) {
            this.pageSize = Integer.parseInt(sessionPageSize);
        }

        if (!StringUtils.isEmpty(sortname)) {
            this.sortname = sortname;
        }
        if (!StringUtils.isEmpty(sortorder)) {
            this.sortorder = sortorder;
        }
        if (page != null) {
            this.pageNo = Integer.parseInt(page);
        } else if (cookiePage != null) {
            this.pageNo = Integer.parseInt(cookiePage);
        } else if (sessionPage != null) {
            this.pageNo = Integer.parseInt(sessionPage);
        }


        if (StringUtils.isEmpty(this.sortname) || this.sortname.indexOf(" ") > 0) {
            this.sortname = "id";
        }
        char[] chars = this.sortname.toCharArray();
        StrBuilder sb = new StrBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'A' && chars[i] < 'Z') {
                sb.append('_');
            }
            sb.append(chars[i]);
        }
        this.sortname = sb.toString();


        if (StringUtils.isEmpty(this.sortorder)) {
            this.sortorder = "desc";
        }
        if (this.sortorder.toLowerCase().equals("desc") || this.sortorder.toLowerCase().equals("asc")) {

        } else {
            this.sortorder = "desc";
        }

    }

    private void parseCookies(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie.getValue());
        }
    }

    public String getCookieByName(String name) {
        return cookieMap.get(name);
    }
}
