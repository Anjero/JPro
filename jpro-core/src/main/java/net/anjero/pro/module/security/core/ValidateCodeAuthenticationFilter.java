package net.anjero.pro.module.security.core;


import net.anjero.pro.module.security.pojo.SecurityAdmin;
import net.anjero.pro.module.security.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Panda on 2016/1/15.
 */
public class ValidateCodeAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private int maxLogin;

    private long time;

    public int getMaxLogin() {
        return maxLogin;
    }

    public void setMaxLogin(int maxLogin) {
        this.maxLogin = maxLogin;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    @Autowired
    private AdminService adminService;

    /**
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     *
     * @author puqignwen
     * @time 2016-4-20 14:18:14
     * @desc 修复登录错误提示
     */
   @Override
public Authentication attemptAuthentication(HttpServletRequest request,
                                            HttpServletResponse response) throws AuthenticationException {
       // 只接受POST方式传递的数据
       if (!"POST".equals(request.getMethod()))
           throw new AuthenticationServiceException("不支持非POST方式的请求!");
       //验证码验证
       String requestCaptcha = request.getParameter("code");
       String genCaptcha = (String)request.getSession().getAttribute("index_code");
       if( !genCaptcha.toLowerCase().equals(requestCaptcha.toLowerCase())){
           throw new AuthenticationServiceException("验证码错误!");
       }

       //判断登陆次数及上限时间
       String username = obtainUsername(request);
       String password = new Md5PasswordEncoder().encodePassword(obtainPassword(request),obtainUsername(request));
       SecurityAdmin securityAdmin = adminService.login(username);
       if (securityAdmin == null){
           throw new AuthenticationServiceException("用户名或密码错误!");
       }else{
           if(securityAdmin.getLoginAttempts() >= maxLogin){
               Calendar dateOne=Calendar.getInstance(),dateTwo=Calendar.getInstance();
               dateOne.setTime(new Date());
               dateTwo.setTime(securityAdmin.getLoginAttemptsTime());
               long timeOne=dateOne.getTimeInMillis();
               long timeTwo=dateTwo.getTimeInMillis();
               long minute=(timeOne-timeTwo)/(1000*60);//转化minute
               if(minute < time){
                   throw new AuthenticationServiceException("密码错误超过"+maxLogin+"次，账号已被锁定"+time+"分钟");
               }else{
                   securityAdmin.setLoginAttempts(0);
               }
           }
       }
       SecurityAdmin admin = adminService.apiLogin(username, password);
       if(admin == null){
           if(securityAdmin.getLoginAttempts() < maxLogin){
               securityAdmin.setLoginAttempts(securityAdmin.getLoginAttempts()+1);
           }
           securityAdmin.setLoginAttemptsTime(new Date());
           adminService.update(securityAdmin);
           throw new AuthenticationServiceException("用户名或密码错误");
       }else{
           admin.setLoginAttempts(0);
           admin.setLoginAttemptsTime(new Date());
           adminService.update(admin);
       }
       request.getSession().setAttribute("workStatus",admin.getWorkStauts());
       return super.attemptAuthentication(request, response);
   }
}
