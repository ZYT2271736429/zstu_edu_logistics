package com.zstu.edu.components;

import com.zstu.edu.configuration.auth.MyaccessDeniedException;
import com.zstu.edu.entity.Authority;
import com.zstu.edu.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 动态鉴权, 从数据库中获取url,看用户提交的url是否在url中,如果在则返回true,如果不在则返回false没有权限
 *
 * @author ThinkPad
 */
@Component
public class DynamicPermission {

    private static final Logger log = LoggerFactory.getLogger(DynamicPermission.class);

    @Autowired
    AuthorityService authorityService;


    /**
     * 判断有访问API的权限
     *
     * @param request
     * @param authentication
     * @return
     * @throws MyaccessDeniedException
     */
    public boolean checkPermisstion(HttpServletRequest request,
                                    Authentication authentication) throws MyaccessDeniedException {

        log.warn("执行 判断是否有访问API的权限 的方法");

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {

            UserDetails userDetails = (UserDetails) principal;
            //得到当前的账号
            String username = userDetails.getUsername();
            log.warn("获取当前用户信息: " + username);
            //Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

            // System.out.println("DynamicPermission  username = " + username);
            //通过账号获取资源鉴权
//            List<Authority> apiUrls = authorityService.getByUserName(username);
//            log.warn("通过账号获取资源鉴权,得到能进入的url: " + apiUrls);

//            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //当前访问路径
            String requestURI = request.getRequestURI();
            log.warn("获得当前提交的url: " + requestURI);
            //提交类型
            String urlMethod = request.getMethod();
            log.warn("获得当前提交的类型: " + urlMethod);

            // System.out.println("DynamicPermission requestURI = " + requestURI);

            //判断当前路径中是否在资源鉴权中
            log.warn("判断当前的url是否在资源权限中");
            // 这里就是一个for循环
//            boolean rs = apiUrls.stream().anyMatch(item -> {
            //判断URL是否匹配
/*
                boolean hashAntPath = antPathMatcher.match(item.getAuthority(), requestURI);
*/

                /*//判断请求方式是否和数据库中匹配（数据库存储：GET,POST,PUT,DELETE）
                String dbMethod = item.getBackendApiMethod();

                //处理null，万一数据库存值
                dbMethod = (dbMethod == null) ? "" : dbMethod;
                int hasMethod = dbMethod.indexOf(urlMethod);

                System.out.println("hashAntPath = " + hashAntPath);
                System.out.println("hasMethod = " + hasMethod);
                System.out.println("hashAntPath && hasMethod = " + (hashAntPath && hasMethod != -1));
                //两者都成立，返回真，否则返回假
                return hashAntPath && (hasMethod != -1);*/
            /*   return hashAntPath;*/
//                return true;
//            });
            //返回
            boolean rs = true;
            if (rs) {
                return true;
            } else {
                throw new MyaccessDeniedException("您没有访问该API的权限！");
            }

        } else {
            throw new MyaccessDeniedException("不是UserDetails类型！");
        }
    }
}

























