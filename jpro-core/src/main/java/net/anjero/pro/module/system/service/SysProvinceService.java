package net.anjero.pro.module.system.service;


import net.anjero.pro.module.system.mapper.SysProvinceMapper;
import net.anjero.pro.module.system.pojo.SysProvince;
import net.anjero.pro.module.system.pojo.SysProvinceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SysProvinceService {

    @Autowired
    private SysProvinceMapper provinceMapper;


    public SysProvince selectById(Integer id) {
        return provinceMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据pid查询
     *
     * @param pid
     * @return
     */
    public List<SysProvince> selectByPid(Integer pid) {
        return selectByPid(pid, true);
    }

    /**
     * 根据pid查询
     *
     * @param pid
     * @return
     */
    public List<SysProvince> selectByPid(Integer pid, boolean all) {
        SysProvinceExample example = new SysProvinceExample();
        SysProvinceExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        if (!all) {
            criteria.andDisplayEqualTo(true);
        }
        example.setOrderByClause(" cname asc ");
        return provinceMapper.selectByExample(example);
    }


    /**
     * 修正获取唯一城市BUG
     * modify tengshaojun
     * 2016-7-27 15:06:13
     */
    /**
     * 获取唯一城市
     * @param name
     * @return
     */
    public SysProvince selectByName(String name) {
        SysProvinceExample example = new SysProvinceExample();
        example.createCriteria().andNameEqualTo(name).andDisplayEqualTo(true);
        example.setOrderByClause(" id");
        List<SysProvince> list =  provinceMapper.selectByExample(example);
        if (list!=null&&list.size()>0)return list.get(0);
        return null;
    }

    /**
     * 查询全部省份
     *
     * @param isAll 是否包含全国
     * @return
     */
    public List<SysProvince> selectAll(Boolean isAll) {
        SysProvinceExample example = new SysProvinceExample();
        example.setOrderByClause(" id asc ");
        SysProvinceExample.Criteria criteria = example.createCriteria();
        criteria.andPidLessThanOrEqualTo(1);
        if (!isAll) criteria.andIdNotEqualTo(100000);
        return provinceMapper.selectByExample(example);
    }

}
