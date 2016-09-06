package net.anjero.pro.module.security.core;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

/**
 * Created by xionghui on 2016/7/7.
 */
public class UserExtend extends User {

    private Integer id;

    private String realName;

    private Integer type;

    private Integer isEnable;

    private Integer loginAttempts;

    private Date loginAttemptsTime;

    private Integer workStauts;

    public UserExtend(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserExtend(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public UserExtend(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer id, String realName, Integer type, Integer isEnable, Integer loginAttempts, Date loginAttemptsTime, Integer workStauts) {
        super(username, password, authorities);
        this.id = id;
        this.realName = realName;
        this.type = type;
        this.isEnable = isEnable;
        this.loginAttempts = loginAttempts;
        this.loginAttemptsTime = loginAttemptsTime;
        this.workStauts = workStauts;
    }

    public UserExtend(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Integer id, String realName, Integer type, Integer isEnable, Integer loginAttempts, Date loginAttemptsTime, Integer workStauts) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.realName = realName;
        this.type = type;
        this.isEnable = isEnable;
        this.loginAttempts = loginAttempts;
        this.loginAttemptsTime = loginAttemptsTime;
        this.workStauts = workStauts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public Date getLoginAttemptsTime() {
        return loginAttemptsTime;
    }

    public void setLoginAttemptsTime(Date loginAttemptsTime) {
        this.loginAttemptsTime = loginAttemptsTime;
    }

    public Integer getWorkStauts() {
        return workStauts;
    }

    public void setWorkStauts(Integer workStauts) {
        this.workStauts = workStauts;
    }

}
