package net.anjero.pro.module.core;

import net.anjero.pro.module.classify.pojo.Classify;
import net.anjero.pro.module.classify.service.ClassifyService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

@Service("JProhelperService")
public class JProHelper {


    @Resource
    private ClassifyService classifyService;


    @Cacheable(value = "selectClassifiesCache")
    public List<Classify> selectClassifies() {
        return classifyService.list(Boolean.TRUE);
    }

    public List<Classify> selectClassifiesNoSys() {
        return classifyService.selectClassifyBySys(null);
    }


    @Cacheable(value = "selectFooterCache")
    public Classify footer() {
        return classifyService.selectByKey("footer");
    }

}
