package com.zstu.edu.configuration.auth;

import com.baomidou.mybatisplus.extension.api.R;
import com.zstu.edu.components.TokenCache;
import com.zstu.edu.entity.User;
import com.zstu.edu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功操作
 *
 * @author ThinkPad
 */
@Component
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(MyUsernamePasswordAuthenticationFilter.class);

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        log.warn("登录成功后的处理");

        //取得账号信息
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.warn("登录成功后获取账号信息: " + userDetails);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //
        System.out.println("userDetails = " + userDetails);
        //取token
        //好的解决方案，登录成功后token存储到数据库中
        //只要token还在过期内，不需要每次重新生成
        //先去缓存中找
        log.warn("去缓存中取Token");
        String token = TokenCache.getTokenFromCache(userDetails.getUsername());
        if (token == null) {
            log.warn("缓存中没有token: 初次登录，token还没有，生成新token。。。。。。");
            System.out.println("初次登录，token还没有，生成新token。。。。。。");
            //如果token为空，则去创建一个新的token
            //jwtTokenUtil = new JwtTokenUtil();
            token = jwtTokenUtil.generateToken(userDetails);
            //把新的token存储到缓存中
            log.warn("把新的token存储到缓存中");
            TokenCache.setToken(userDetails.getUsername(), token);
        }

        //加载前端菜单
        log.warn("加载前端菜单");
//        List<SysFrontendMenuTable> menus = service.getMenusByUserName(userDetails.getUsername());
        //获取用户信息
        User user = userService.getByUsername(userDetails.getUsername());
        log.warn("登录成功以后给前端一个JSON对象");
        Map<String, Object> map = new HashMap<>();
        map.put("username", userDetails.getUsername());
        map.put("auth", userDetails.getAuthorities());
//        map.put("menus", menus);
        map.put("user", user);
        map.put("token", token);
        //装入token
        R<Map<String, Object>> data = R.ok(map);
        data.setCode(200);
        //输出
        log.warn("以JSON的形式封装好后返回给页面");
//        this.WriteJSON(request, response, data);
        this.WriteJSON(request, response, data);

    }
}
