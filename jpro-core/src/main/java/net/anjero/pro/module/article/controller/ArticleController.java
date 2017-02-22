package net.anjero.pro.module.article.controller;

import net.anjero.common.spring.controller.BaseController;
import net.anjero.pro.module.article.pojo.Article;
import net.anjero.pro.module.article.service.ArticleService;
import net.anjero.pro.module.classify.pojo.Classify;
import net.anjero.pro.module.classify.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * <p>polodai Create by 2016/12/28</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。</p>
 *
 * @author :Anjero
 * @version :1.0
 * @company:Cheshell
 */

@Controller
@RequestMapping("/a")
public class ArticleController extends BaseController {

    @Resource
    private ArticleService articleService;

    @Resource
    private ClassifyService classifyService;


    @RequestMapping("/{key}/all")
    public String page(Model model, @PathVariable String key, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize) throws Throwable {
//        Classify classify = classifyService.selectByKey(key);
//        PageInfo<Article> pageInfo = articleService.pageInfo(1, pageSize, Boolean.TRUE, classify.getId());
//        model.addAttribute("page", pageInfo);
//        model.addAttribute("footer", classifyService.selectByKey("footer"));
        throw  new Throwable("no!!");
//        return "web/v_default/blogs";
    }

    @RequestMapping("/{key}/{id}.html")
    public String detail(@PathVariable String key, @PathVariable Integer id, Model model) {
        Classify classify = classifyService.selectByKey(key);
        Article article = articleService.selectById(id);

        //此类别下文章才能正常显示
        if (article.getClassifyId() != classify.getId()) {
            return redirect("/404");
        }
        model.addAttribute(article);
        return "web/v_default/detail/blog";
    }
}
