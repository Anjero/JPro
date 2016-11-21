package net.anjero.pro.module.index;

import com.github.pagehelper.PageInfo;
import net.anjero.pro.common.spring.controller.BaseController;
import net.anjero.pro.module.article.service.ArticleService;
import net.anjero.pro.module.article.pojo.Article;
import net.anjero.pro.module.classify.pojo.Classify;
import net.anjero.pro.module.classify.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping(value = "/{key}.html", method = RequestMethod.GET)
    public String view(@PathVariable String key, Model model) {

        Classify classify = classifyService.selectByKey(key);
        if (classify == null || (classify != null && !classify.getIsShow())) {
            return redirect("/404");
        }
        PageInfo<Article> pageInfo = articleService.pageInfo(1, 5, Boolean.TRUE, classify.getId());
        model.addAttribute("page", pageInfo);
        List<Classify> classifies = classifyService.list(Boolean.TRUE);
        model.addAttribute("classifies", classifies);
        model.addAttribute("template", "default");
        model.addAttribute("footer", classifyService.selectByKey("footer"));
        return "web/index";
    }

    @RequestMapping("/{key}/{id}.html")
    public String detail(@PathVariable String key, Model model, @PathVariable Integer id) {
        Article article = articleService.selectById(id);
        model.addAttribute("article", article);

        model.addAttribute("template", "default");

        List<Classify> classifies = classifyService.list(Boolean.TRUE);
        model.addAttribute("classifies", classifies);

        model.addAttribute("footer", classifyService.selectByKey("footer"));
        return "web/detail";
    }
}
