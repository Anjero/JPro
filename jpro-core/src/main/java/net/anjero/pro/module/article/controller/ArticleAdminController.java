package net.anjero.pro.module.article.controller;

import com.github.pagehelper.PageInfo;
import net.anjero.common.core.exception.ForbiddenJsonException;
import net.anjero.common.spring.MediaType;
import net.anjero.common.spring.controller.BaseAdminController;
import net.anjero.pro.module.article.pojo.Article;
import net.anjero.pro.module.article.service.ArticleService;
import net.anjero.pro.module.classify.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 文章管理
 * <p>Create by 2016/12/8</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。</p>
 *
 * @author :Anjero
 * @version :1.0
 * @company:Cheshell
 */

@Controller
@RequestMapping("/admin/article")
public class ArticleAdminController extends BaseAdminController {


    private static final long serialVersionUID = 7405574230367089945L;

    @Resource
    private ArticleService articleService;

    @Resource
    private ClassifyService classifyService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") Integer pageNo) {
        PageInfo page = articleService.pageInfo(pageNo, 20, null, 3);
        model.addAttribute("page", page);
        return "admin/article/index";
    }

    @RequestMapping("/add")
    public String add() {
        return "admin/article/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.JSON_UTF_8)
    @ResponseBody
    public String save(String title, String identityNo, String link, String imagePath, String tag, Integer displayIndex, String source,
                       Integer classifyId, String remark, String content, Boolean isShow, Boolean isTop, Boolean isComment) throws ForbiddenJsonException {

        Article article = new Article();
        article.setImagePath(imagePath);
        article.setTitle(title);
        article.setIdentityNo(identityNo);
        article.setLink(link);
        article.setTag(tag);
        article.setDisplayIndex(displayIndex);
        article.setSource(source);
        article.setIsShow(isShow);
        article.setIsTop(isTop);
        article.setIsComment(isComment);
        article.setRemark(remark);
        article.setContent(content);
        article.setClassifyId(classifyId);
        article.setInTime(new Date());
        article.setModifyTime(article.getInTime());
        article.setAuthor(getAdminId());
        article.setClick(1);

        articleService.insert(article);
        return success();
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {

        Article article = articleService.selectById(id);

        model.addAttribute("article", article);
        return "admin/article/edit";
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
