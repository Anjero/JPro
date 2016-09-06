package net.anjero.pro.module.company.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.anjero.pro.module.company.mapper.CompanyMapper;
import net.anjero.pro.module.company.pojo.Company;
import net.anjero.pro.module.company.pojo.CompanyExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Anjero on 16/9/6.
 */

@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;


    public void insert(Company company) {
        companyMapper.insert(company);
    }

    public PageInfo page(Integer pageNum) {
        PageHelper.startPage(pageNum, 20);
        CompanyExample example = new CompanyExample();
        List<Company> list = companyMapper.selectByExample(example);
        PageInfo page = new PageInfo<Company>(list);
        return page;
    }

    public void update(Company company){
        companyMapper.updateByPrimaryKey(company);
    }
}
