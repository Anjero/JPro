package net.anjero.pro.module.security.mapper;

import net.anjero.pro.module.security.pojo.SecurityRole;
import net.anjero.pro.module.security.pojo.SecurityRoleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SecurityRoleMapper {
    int countByExample(SecurityRoleExample example);

    int deleteByExample(SecurityRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityRole record);

    int insertSelective(SecurityRole record);

    List<SecurityRole> selectByExampleWithRowbounds(SecurityRoleExample example, RowBounds rowBounds);

    List<SecurityRole> selectByExample(SecurityRoleExample example);

    SecurityRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecurityRole record, @Param("example") SecurityRoleExample example);

    int updateByExample(@Param("record") SecurityRole record, @Param("example") SecurityRoleExample example);

    int updateByPrimaryKeySelective(SecurityRole record);

    int updateByPrimaryKey(SecurityRole record);

    List<SecurityRole> selectByAdmin(Integer adminId);

    int deleteRoleAuths(Integer id);

    int insertRoleAuth(Map<String, Integer> params);
}