package net.anjero.pro.module.article.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.anjero.pro.module.article.mapper.ArticleMapper;
import net.anjero.pro.module.article.pojo.Article;
import net.anjero.pro.module.article.pojo.ArticleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Anjero on 16/9/20.
 */

@Service
public class ArticleService {


    @Resource
    private ArticleMapper articleMapper;

    public Article selectById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public PageInfo<Article> pageInfo(int pageNo, int pageSize, Boolean isShow, Integer classifyId) {
        PageHelper.startPage(pageNo, pageSize);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        if (isShow != null) {
            criteria.andIsShowEqualTo(isShow);
        }
        if (classifyId != null) {
            criteria.andClassifyIdEqualTo(classifyId);
        }
        List<Article> articles = articleMapper.selectByExample(articleExample);
        PageInfo<Article> articlePageInfo = new PageInfo<Article>(articles);
        return articlePageInfo;
    }

    //根据版块查询文章
    public List<Article> selectByClassifyId(Integer classifyId) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andClassifyIdEqualTo(classifyId);
        List<Article> articles = articleMapper.selectByExample(articleExample);
        return articles;
    }


    public Article insert(Article article) {
        int num = articleMapper.insert(article);
        return num > 0 ? article : null;
    }

    public Article update(Article article) {
        int num = articleMapper.updateByPrimaryKeyWithBLOBs(article);
        return num > 0 ? article : null;
    }
}
