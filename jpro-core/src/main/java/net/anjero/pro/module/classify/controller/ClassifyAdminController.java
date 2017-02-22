package net.anjero.pro.module.classify.controller;

import net.anjero.common.spring.MediaType;
import net.anjero.common.spring.controller.BaseAdminController;
import net.anjero.pro.module.classify.pojo.Classify;
import net.anjero.pro.module.classify.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Anjero on 16/9/13.
 */

@Controller
@RequestMapping("/admin/classify")
public class ClassifyAdminController extends BaseAdminController {


    private static final long serialVersionUID = 765977303305700212L;


    @Resource
    private ClassifyService classifyService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Classify> classifies = classifyService.list(Boolean.TRUE);

        model.addAttribute("list", classifies);
        return "admin/classify/index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "admin/classify/add";
    }

    @RequestMapping("/save")
    public String save(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

    @RequestMapping("/edit/{id}")
    public String edit(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
        return "";
    }

    @RequestMapping("/update/{id}")
    public void update(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
        returnJson("", request, response);
    }

    @RequestMapping(value = "/delete/{id}.json", method = RequestMethod.POST, produces = MediaType.JSON_UTF_8)
    @ResponseBody
    public void delete(HttpServletRequest request, HttpServletResponse response) {

        returnJson("", request, response);
    }
}
