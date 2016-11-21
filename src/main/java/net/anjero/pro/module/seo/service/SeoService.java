package net.anjero.pro.module.seo.service;

import net.anjero.pro.module.seo.mapper.SeoMapper;
import net.anjero.pro.module.seo.pojo.SeoExample;
import net.anjero.pro.module.seo.pojo.SeoWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Anjero on 16/9/19.
 */

@Service
public class SeoService {

    @Resource
    private SeoMapper seoMapper;

    public void insert(SeoWithBLOBs seo) {
        seoMapper.insert(seo);
    }

    public void update(SeoWithBLOBs seo) {
        seoMapper.updateByPrimaryKeyWithBLOBs(seo);
    }


    /**
     * 查询
     * @param companyId
     * @return
     */
    public SeoWithBLOBs selectByCompanyId(Integer companyId) {
        SeoExample seoExample = new SeoExample();
        seoExample.createCriteria().andCompanyIdEqualTo(companyId);


        List<SeoWithBLOBs> list = seoMapper.selectByExampleWithBLOBs(seoExample);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;


    }
}
