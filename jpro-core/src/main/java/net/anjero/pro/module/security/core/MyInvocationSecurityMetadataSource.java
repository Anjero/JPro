package net.anjero.pro.module.security.core;

import net.anjero.pro.module.security.pojo.SecurityAuth;
import net.anjero.pro.module.security.service.AuthService;
import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 *
 * @author Robin
 */
@Service
public class MyInvocationSecurityMetadataSource implements
        FilterInvocationSecurityMetadataSource {

    private static Logger log = Logger.getLogger("web");
    @Resource
    private AuthService authService;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 加载资源，初始化资源变量
     */
    public void loadResourceDefine() {
        map = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<SecurityAuth> auths = authService.selectAll();
        for (SecurityAuth auth : auths) {
            array = new ArrayList<ConfigAttribute>();
            cfg = new SecurityConfig(auth.getName());
            array.add(cfg);
            map.put(auth.getUrl(), array);
        }
        log.info("security info load sucess!!");
    }


    /**
     * 根据路径获取访问权限的集合接口
     *
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        if (map == null) {
            loadResourceDefine();
        }
        HttpServletRequest request = ((FilterInvocation) object)
                .getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (null != resUrl && matcher.matches(request)) {
                return map.get(resUrl);
            }
        }

        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        if(map==null){
//            loadResourceDefine();
//        }
//        Collection<ConfigAttribute> configAttributes =  new ArrayList<ConfigAttribute>();
//        for (String s : map.keySet()) {
//            configAttributes.addAll(map.get(s));
//        }
//        return configAttributes;
        return null;
    }

    /**
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
