package net.anjero.pro.module.index;

import net.anjero.common.spring.controller.BaseController;
import net.anjero.pro.module.article.pojo.Article;
import net.anjero.pro.module.article.service.ArticleService;
import net.anjero.pro.module.classify.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * ///////////////////////////////////////
 * <p>Create by 2017/3/15</p>
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
@RequestMapping
public class D5divingViewController extends BaseController {


    @Resource
    private ArticleService articleService;

    @Resource
    private ClassifyService classifyService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "web/margo/template/index";
    }

    @RequestMapping(value = "/course.html", method = RequestMethod.GET)
    public String course(Model model) {


        List<Article> articles = articleService.selectByClassifyId(classifyService.selectByKey("course").getId());
        model.addAttribute("courses", articles);
        return "web/margo/template/course/list";
    }

    @RequestMapping(value = "/equipment.html", method = RequestMethod.GET)
    public String equipments(Model model) {
        List<Article> articles = articleService.selectByClassifyId(classifyService.selectByKey("equipment").getId());
        model.addAttribute("equipments", articles);
        return "web/margo/template/equipment/list";
    }


    @RequestMapping(value = "/coach.html", method = RequestMethod.GET)
    public String coach(Model model) {
        List<Article> articles = articleService.selectByClassifyId(classifyService.selectByKey("coach").getId());
        model.addAttribute("coaches", articles);
        return "web/margo/template/coach/list";
    }

    @RequestMapping(value = "/picture.html", method = RequestMethod.GET)
    public String picture(Model model) {
        List<Article> articles = articleService.selectByClassifyId(classifyService.selectByKey("coach").getId());
        model.addAttribute("pictures", articles);
        return "web/margo/template/picture/list";
    }

    @RequestMapping(value = "/contact.html", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("article", articleService.selectById(15));
        return "web/margo/template/contact/contact";
    }

}
