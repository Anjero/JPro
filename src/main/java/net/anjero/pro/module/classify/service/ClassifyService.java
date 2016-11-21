package net.anjero.pro.module.classify.service;

import net.anjero.pro.module.classify.mapper.ClassifyMapper;
import net.anjero.pro.module.classify.pojo.Classify;
import net.anjero.pro.module.classify.pojo.ClassifyExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Anjero on 16/9/13.
 */

@Service
public class ClassifyService {

    @Resource
    private ClassifyMapper classifyMapper;

    public List<Classify> list(Boolean isShow) {
        ClassifyExample classifyExample = new ClassifyExample();
        ClassifyExample.Criteria criteria = classifyExample.createCriteria();
        if (isShow != null) {
            criteria.andIsShowEqualTo(isShow);
        }
        classifyExample.setOrderByClause(" display_index asc");
        return classifyMapper.selectByExample(classifyExample);
    }

    public Classify selectByKey(String key){
        ClassifyExample classifyExample = new ClassifyExample();
        ClassifyExample.Criteria criteria = classifyExample.createCriteria();
        criteria.andClassifyIdentifyEqualTo(key);
        List<Classify> list = classifyMapper.selectByExampleWithBLOBs(classifyExample);;
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public int insert(Classify classify) {
        return classifyMapper.insert(classify);
    }

    public int update(Classify classify) {
        return classifyMapper.updateByPrimaryKey(classify);
    }

    public int delete(Integer id) {
        return classifyMapper.deleteByPrimaryKey(id);
    }
}
