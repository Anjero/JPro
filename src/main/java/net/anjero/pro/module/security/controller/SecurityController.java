package net.anjero.pro.module.security.controller;


import net.anjero.pro.common.spring.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class SecurityController extends BaseAdminController {


    /**
     *
     */
    private static final long serialVersionUID = 7368679805049619254L;

    @RequestMapping(value = "/adminlogin")
    public String adminLogin(HttpServletRequest request, Model model) {
        System.out.println("gays want to login");
        String error = request.getParameter("error");
        if (!StringUtils.isEmpty(error)) {
            model.addAttribute("error", error);
        }
        return "admin/security/panel/login";
    }

    @RequestMapping(value = "/adminregister")
    public String adminRegister(HttpServletRequest request, Model model) {
        System.out.println("gays want to register");
        String error = request.getParameter("error");
        if (!StringUtils.isEmpty(error)) {
            model.addAttribute("error", error);
        }
        return "admin/member/register";
    }
}
