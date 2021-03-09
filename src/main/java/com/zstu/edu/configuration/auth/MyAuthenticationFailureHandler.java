package com.zstu.edu.configuration.auth;


import com.baomidou.mybatisplus.extension.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败操作
 *
 * @author ThinkPad
 */
@Component
public class MyAuthenticationFailureHandler extends JSONAuthentication implements AuthenticationFailureHandler {

    private static final Logger log = LoggerFactory.getLogger(MyUsernamePasswordAuthenticationFilter.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {

        log.warn("登陆失败处理, 返回异常: 登录失败:", e.getMessage());
        R<String> data = R.failed("登录失败:" + e.getMessage());
        data.setCode(500);
        //输出
        this.WriteJSON(request, response, data);
    }
}
