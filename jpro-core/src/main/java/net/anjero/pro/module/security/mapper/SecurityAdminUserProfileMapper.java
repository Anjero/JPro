package net.anjero.pro.module.security.mapper;

import java.util.List;
import net.anjero.pro.module.security.pojo.SecurityAdminUserProfile;
import net.anjero.pro.module.security.pojo.SecurityAdminUserProfileExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SecurityAdminUserProfileMapper {
    int countByExample(SecurityAdminUserProfileExample example);

    int deleteByExample(SecurityAdminUserProfileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityAdminUserProfile record);

    int insertSelective(SecurityAdminUserProfile record);

    List<SecurityAdminUserProfile> selectByExampleWithRowbounds(SecurityAdminUserProfileExample example, RowBounds rowBounds);

    List<SecurityAdminUserProfile> selectByExample(SecurityAdminUserProfileExample example);

    SecurityAdminUserProfile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecurityAdminUserProfile record, @Param("example") SecurityAdminUserProfileExample example);

    int updateByExample(@Param("record") SecurityAdminUserProfile record, @Param("example") SecurityAdminUserProfileExample example);

    int updateByPrimaryKeySelective(SecurityAdminUserProfile record);

    int updateByPrimaryKey(SecurityAdminUserProfile record);
}