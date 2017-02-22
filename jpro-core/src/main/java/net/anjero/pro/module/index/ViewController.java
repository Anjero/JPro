package net.anjero.pro.module.index;

import com.github.pagehelper.PageInfo;
import net.anjero.common.spring.controller.BaseController;
import net.anjero.pro.module.article.pojo.Article;
import net.anjero.pro.module.article.service.ArticleService;
import net.anjero.pro.module.classify.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by Anjero on 16/9/20.
 */

@Controller
public class ViewController extends BaseController {

    private static final long serialVersionUID = 6416113301296907201L;


    @Resource
    private ArticleService articleService;

    @Resource
    private ClassifyService classifyService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String view(Model model) {
        return "web/default/index";
    }

    @RequestMapping(value = "/blogs.html", method = RequestMethod.GET)
    public String blogs(@RequestParam(defaultValue = "1") Integer pageNo, Model model) {
        PageInfo page = articleService.pageInfo(pageNo, 20, true, 3);
        model.addAttribute("page", page);
        return "web/default/blogs";
    }

    @RequestMapping(value = "/blogs/{id}.html", method = RequestMethod.GET)
    public String blog(@PathVariable Integer id, Model model) {
        Article article = articleService.selectById(id);
        model.addAttribute("article", article);
        return "web/default/detail/blog";
    }

    @RequestMapping(value = "/contact.html", method = RequestMethod.GET)
    public String contact() {
        return "web/default/contact";
    }


    @RequestMapping(value = "/about.html", method = RequestMethod.GET)
    public String about() {
        return "web/default/about";
    }

}


