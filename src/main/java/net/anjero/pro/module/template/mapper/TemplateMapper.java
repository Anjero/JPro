package net.anjero.pro.module.template.mapper;

import java.util.List;
import net.anjero.pro.module.template.pojo.Template;
import net.anjero.pro.module.template.pojo.TemplateExample;
import net.anjero.pro.module.template.pojo.TemplateWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TemplateMapper {
    int countByExample(TemplateExample example);

    int deleteByExample(TemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TemplateWithBLOBs record);

    int insertSelective(TemplateWithBLOBs record);

    List<TemplateWithBLOBs> selectByExampleWithBLOBsWithRowbounds(TemplateExample example, RowBounds rowBounds);

    List<TemplateWithBLOBs> selectByExampleWithBLOBs(TemplateExample example);

    List<Template> selectByExampleWithRowbounds(TemplateExample example, RowBounds rowBounds);

    List<Template> selectByExample(TemplateExample example);

    TemplateWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TemplateWithBLOBs record, @Param("example") TemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") TemplateWithBLOBs record, @Param("example") TemplateExample example);

    int updateByExample(@Param("record") Template record, @Param("example") TemplateExample example);

    int updateByPrimaryKeySelective(TemplateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TemplateWithBLOBs record);

    int updateByPrimaryKey(Template record);
}