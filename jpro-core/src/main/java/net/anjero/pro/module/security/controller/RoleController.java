package net.anjero.pro.module.security.controller;

import net.anjero.common.spring.controller.BaseController;
import net.anjero.pro.module.security.pojo.SecurityAuth;
import net.anjero.pro.module.security.pojo.SecurityRole;
import net.anjero.pro.module.security.service.AuthService;
import net.anjero.pro.module.security.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/security/role/*")
public class RoleController extends BaseController {
    private static final long serialVersionUID = 783842478181293901L;
    @Resource
    private RoleService roleService;
    @Resource
    private AuthService authService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<SecurityRole> list = roleService.selectAll();
        model.addAttribute("list", list);
        return "admin/security/role/list";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        List<SecurityAuth> auths = authService.selectAll();
        model.addAttribute("auths", auths);
        return "admin/security/role/add";
    }

    @RequestMapping(value = "/save")
    public String save(String name, Integer auth[], Model model) {
        SecurityRole role = new SecurityRole();
        role.setName(name);
        roleService.save(role, auth);
        return redirect("/admin/security/role/list");
    }

    @RequestMapping(value = "/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        SecurityRole role = roleService.selectById(id);
        List<SecurityAuth> auths = authService.selectAll();
        List<SecurityAuth> roleAuths = authService.selectByRole(id);
        model.addAttribute("role", role);
        model.addAttribute("auths", auths);
        model.addAttribute("roleAuths", roleAuths);
        return "/admin/security/role/edit";
    }

    @RequestMapping(value = "/{id}/update")
    public String update(@PathVariable Integer id, String name, Integer auth[],
                         Model model) {
        SecurityRole role = roleService.selectById(id);
        role.setName(name);
        roleService.update(role, auth);
        return redirect("/admin/security/role/list");
    }

    @RequestMapping(value = "/{id}/delete")
    public String save(@PathVariable Integer id, Model model) {
        roleService.delete(id);
        return redirect("/admin/security/role/list");
    }

}
