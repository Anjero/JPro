package net.anjero.pro.module.security.pojo;

import java.io.Serializable;
import java.util.Date;

public class SecurityAdmin implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String realName;

    private Integer type;

    private Integer isEnable;

    private Integer loginAttempts;

    private Date loginAttemptsTime;

    private Integer workStauts;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", type=").append(type);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", loginAttempts=").append(loginAttempts);
        sb.append(", loginAttemptsTime=").append(loginAttemptsTime);
        sb.append(", workStauts=").append(workStauts);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}