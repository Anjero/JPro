package net.anjero.pro.module.system.mapper;

import net.anjero.pro.module.system.pojo.SysProvince;
import net.anjero.pro.module.system.pojo.SysProvinceExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SysProvinceMapper {
    int countByExample(SysProvinceExample example);

    int deleteByExample(SysProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysProvince record);

    int insertSelective(SysProvince record);

    List<SysProvince> selectByExampleWithRowbounds(SysProvinceExample example, RowBounds rowBounds);

    List<SysProvince> selectByExample(SysProvinceExample example);

    SysProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysProvince record, @Param("example") SysProvinceExample example);

    int updateByExample(@Param("record") SysProvince record, @Param("example") SysProvinceExample example);

    int updateByPrimaryKeySelective(SysProvince record);

    int updateByPrimaryKey(SysProvince record);

    /**
     * 查找唯一
     *
     * @param example
     * @return
     */
    SysProvince selectUnByExample(SysProvinceExample example);
}