package net.anjero.pro.module.security.core;


import net.anjero.pro.module.security.pojo.SecurityAdmin;
import net.anjero.pro.module.security.pojo.SecurityAuth;
import net.anjero.pro.module.security.service.AdminService;
import net.anjero.pro.module.security.service.AuthService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Resource
    private AdminService adminService;
    @Resource
    private AuthService authService;


    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        SecurityAdmin admin;
        Collection<GrantedAuthority> auths;
        admin = adminService.login(username);
        if (admin != null) {
            List<SecurityAuth> adminAuths = authService.selectByAdmin(admin.getId());
            auths = new ArrayList<GrantedAuthority>();
            for (SecurityAuth auth : adminAuths) {
                GrantedAuthority ga = new SimpleGrantedAuthority(auth.getName());
                auths.add(ga);
            }
            return new UserExtend(username, admin.getPassword(), true, true, true, true, auths,admin.getId(),admin.getRealName(),admin.getType(),admin.getIsEnable(),admin.getLoginAttempts(),admin.getLoginAttemptsTime(),admin.getWorkStauts());
        } else {
            throw new UsernameNotFoundException("admin:" + username + " do not exist!!");
        }

    }

}
