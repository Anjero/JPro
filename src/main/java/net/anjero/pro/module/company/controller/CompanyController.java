package net.anjero.pro.module.company.controller;

import com.github.pagehelper.PageInfo;
import net.anjero.pro.common.spring.controller.BaseAdminController;
import net.anjero.pro.module.company.pojo.Company;
import net.anjero.pro.module.company.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Anjero on 16/9/6.
 */

@Controller
@RequestMapping("/admin/company")
public class CompanyController extends BaseAdminController {

    private static final long serialVersionUID = -4546640543198071654L;

    @Resource
    private CompanyService companyService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(required = false, defaultValue = "1") Integer pageNo) {
        PageInfo pageInfo = companyService.page(pageNo);
        model.addAttribute("page", pageInfo);
        return "admin/company/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "admin/company/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(Company company) {
        company.setInTime(new Date());
        company.setModifyTime(company.getInTime());

        companyService.insert(company);
        return redirect("/admin/company/index");
    }
}
