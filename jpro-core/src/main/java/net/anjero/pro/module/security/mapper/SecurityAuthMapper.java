package net.anjero.pro.module.security.mapper;

import net.anjero.pro.module.security.pojo.SecurityAuth;
import net.anjero.pro.module.security.pojo.SecurityAuthExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SecurityAuthMapper {
    int countByExample(SecurityAuthExample example);

    int deleteByExample(SecurityAuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityAuth record);

    int insertSelective(SecurityAuth record);

    List<SecurityAuth> selectByExampleWithRowbounds(
            SecurityAuthExample example, RowBounds rowBounds);

    List<SecurityAuth> selectByExample(SecurityAuthExample example);

    SecurityAuth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecurityAuth record,
                                 @Param("example") SecurityAuthExample example);

    int updateByExample(@Param("record") SecurityAuth record,
                        @Param("example") SecurityAuthExample example);

    int updateByPrimaryKeySelective(SecurityAuth record);

    int updateByPrimaryKey(SecurityAuth record);

    List<SecurityAuth> selectByRole(Integer roleId);

    List<SecurityAuth> selectByAdmin(Integer id);
}