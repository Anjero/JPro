package net.anjero.pro.module.security.service;

import net.anjero.pro.module.security.mapper.SecurityAdminUserProfileMapper;
import net.anjero.pro.module.security.pojo.SecurityAdminUserProfile;
import net.anjero.pro.module.security.pojo.SecurityAdminUserProfileExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ///////////////////////////////////////
 * <p>Create by 2017/2/22</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。
 * </p>
 * ///////////////////////////////////////
 *
 * @author :Anjero
 * @version :1.0
 */

@Service
public class AdminUserService {


    @Resource
    private SecurityAdminUserProfileMapper userProfileMapper;


    /**
     * 更新或插入
     *
     * @param userProfile
     * @return
     */
    public SecurityAdminUserProfile saveOrUpdate(SecurityAdminUserProfile userProfile) {

        SecurityAdminUserProfile srcUser = selectByAdminId(userProfile.getAdminId());
        if (srcUser != null) {
            userProfile.setId(srcUser.getId());
            int num = userProfileMapper.updateByPrimaryKey(userProfile);
            return num > 0 ? userProfile : null;
        }
        int num = userProfileMapper.insert(userProfile);
        return num > 0 ? userProfile : null;
    }

    /**
     * 根据adminId 查询
     *
     * @param adminId
     * @return
     */
    public SecurityAdminUserProfile selectByAdminId(Integer adminId) {
        SecurityAdminUserProfileExample example = new SecurityAdminUserProfileExample();
        example.createCriteria().andAdminIdEqualTo(adminId);
        int count = userProfileMapper.countByExample(example);
        if (count > 0) {
            return userProfileMapper.selectByExample(example).get(0);
        }
        return null;
    }

}
