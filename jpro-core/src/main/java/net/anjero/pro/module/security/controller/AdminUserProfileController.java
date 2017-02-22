package net.anjero.pro.module.security.controller;

import net.anjero.common.core.exception.ForbiddenJsonException;
import net.anjero.common.spring.controller.BaseAdminController;
import net.anjero.pro.module.security.pojo.SecurityAdminUserProfile;
import net.anjero.pro.module.security.service.AdminUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * ///////////////////////////////////////
 * <p>Create by 2017/2/22</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。
 * </p>
 * ///////////////////////////////////////
 *
 * @author :Anjero
 * @version :1.0
 */

@Controller
@RequestMapping("/admin/user/profie")
public class AdminUserProfileController extends BaseAdminController {

    private static final long serialVersionUID = -7823486491066469302L;

    @Resource
    private AdminUserService adminUserService;

    @RequestMapping("/index")
    public String index(Model model) throws ForbiddenJsonException {
        SecurityAdminUserProfile userProfile = adminUserService.selectByAdminId(getAdminId());
        model.addAttribute("userProfile", userProfile);
        return "admin/security/user/profile/index";
    }
}
