package net.anjero.pro.module.security.controller;

import net.anjero.pro.common.core.exception.ForbiddenJsonException;
import net.anjero.pro.common.spring.controller.BaseAdminController;
import net.anjero.pro.module.security.pojo.SecurityAdmin;
import net.anjero.pro.module.security.service.AdminService;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin/setting/*")
public class SettingController extends BaseAdminController {
    private static final long serialVersionUID = 8758425084033534730L;
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/pwd/change")
    public String changePwd(HttpServletRequest request, Model model) {
        return "admin/security/setting/changepwd";
    }

    @RequestMapping(value = "/pwd/update")
    public String updatePwd(HttpServletRequest request, Model model) throws ForbiddenJsonException {
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword1");
        SecurityAdmin admin = adminService.selectById(getAdmin().getId());
        String md5oldpwd = new Md5PasswordEncoder().encodePassword(oldpassword, admin.getUsername());
        String md5newpwd = new Md5PasswordEncoder().encodePassword(newpassword, admin.getUsername());
        if (admin.getPassword().equals(md5oldpwd)) {
            int i = adminService.updatePwdById(admin.getId(), md5newpwd);
            if (i > 0) {
                model.addAttribute("errorMsg", "密码修改成功！");
                return "admin/security/setting/succuss";
            } else {
                model.addAttribute("errorMsg", "修改密码失败，请重试！");
                return "admin/security/setting/error";
            }
        } else {
            model.addAttribute("errorMsg", "原密码输入错误！");
            return "admin/security/setting/changepwd";
        }
    }

}
