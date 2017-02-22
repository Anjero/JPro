package net.anjero.plugins.velocity;

import net.anjero.common.util.CookieUtil;

import javax.servlet.http.Cookie;

/**
 * Created by Yang on 2015/5/15.
 */
public class VelocityWebSecurity {

    public static boolean isBuyer() {
        Cookie cookie = CookieUtil.getCookie("agency_buyer");
        if (cookie != null) {
            String agency_buyer = cookie.getValue();
            if (agency_buyer.equals("1")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSeller() {
        Cookie cookie = CookieUtil.getCookie("agency_seller");
        if (cookie != null) {
            String agency_seller = cookie.getValue();
            if (agency_seller.equals("1")) {
                return true;
            }
        }
        return false;
    }


    public static boolean isCompany() {
        Cookie cookie = CookieUtil.getCookie("agency_company");
        if (cookie != null) {
            String agency_company = cookie.getValue();
            if (agency_company.equals("1")) {
                return true;
            }
        }
        return false;
    }

}
