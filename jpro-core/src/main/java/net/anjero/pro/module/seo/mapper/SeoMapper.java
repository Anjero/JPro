package net.anjero.pro.module.seo.mapper;

import java.util.List;
import net.anjero.pro.module.seo.pojo.Seo;
import net.anjero.pro.module.seo.pojo.SeoExample;
import net.anjero.pro.module.seo.pojo.SeoWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SeoMapper {
    int countByExample(SeoExample example);

    int deleteByExample(SeoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SeoWithBLOBs record);

    int insertSelective(SeoWithBLOBs record);

    List<SeoWithBLOBs> selectByExampleWithBLOBsWithRowbounds(SeoExample example, RowBounds rowBounds);

    List<SeoWithBLOBs> selectByExampleWithBLOBs(SeoExample example);

    List<Seo> selectByExampleWithRowbounds(SeoExample example, RowBounds rowBounds);

    List<Seo> selectByExample(SeoExample example);

    SeoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SeoWithBLOBs record, @Param("example") SeoExample example);

    int updateByExampleWithBLOBs(@Param("record") SeoWithBLOBs record, @Param("example") SeoExample example);

    int updateByExample(@Param("record") Seo record, @Param("example") SeoExample example);

    int updateByPrimaryKeySelective(SeoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SeoWithBLOBs record);

    int updateByPrimaryKey(Seo record);
}