package net.anjero.pro.module.classify.mapper;

import net.anjero.pro.module.classify.pojo.Classify;
import net.anjero.pro.module.classify.pojo.ClassifyExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ClassifyMapper {
    int countByExample(ClassifyExample example);

    int deleteByExample(ClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classify record);

    int insertSelective(Classify record);

    List<Classify> selectByExampleWithBLOBsWithRowbounds(ClassifyExample example, RowBounds rowBounds);

    List<Classify> selectByExampleWithBLOBs(ClassifyExample example);

    List<Classify> selectByExampleWithRowbounds(ClassifyExample example, RowBounds rowBounds);

    List<Classify> selectByExample(ClassifyExample example);

    Classify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByExampleWithBLOBs(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByExample(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKeyWithBLOBs(Classify record);

    int updateByPrimaryKey(Classify record);
}