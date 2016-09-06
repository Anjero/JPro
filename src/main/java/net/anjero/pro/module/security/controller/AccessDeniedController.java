package net.anjero.pro.module.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>cheshell Create by 14/11/17 下午5:18</p>
 *
 * @author :anjero by Cheshell Copyright (c) 2012
 * @version :1.0
 */

@Controller
public class AccessDeniedController {


    @RequestMapping("/accessDenied")
    public String accessDenied() {

        return "admin/security/panel/accessDenied";
    }

    @RequestMapping("/404")
    public String notfound() {
        return "404";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
}
