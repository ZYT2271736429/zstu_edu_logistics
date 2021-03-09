package com.zstu.edu.configuration.auth;

import com.baomidou.mybatisplus.extension.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 成功退出处理器
 */
@Component
public class MyLogoutSuccessHandler extends JSONAuthentication implements LogoutSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(MyLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
//        UserDetails user = (UserDetails) authentication.getPrincipal();
//        String username = user.getUsername();
        log.warn("执行 退出 的方法");

        R<String> data = R.ok("退出成功");
        super.WriteJSON(request,response,data);
    }
}
