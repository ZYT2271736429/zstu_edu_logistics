package com.zstu.edu.configuration.auth;

import com.baomidou.mybatisplus.extension.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限校验处理器
 * @author ThinkPad
 */
@Component
public class MyAccessDeniedHandler extends JSONAuthentication implements AccessDeniedHandler {
    private static final Logger log = LoggerFactory.getLogger(MyAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        log.warn("权限校验不足");
        //装入token
        R<String> data = R.failed("权限不足:"+accessDeniedException.getMessage());
        //输出
        this.WriteJSON(request, response, data);
    }
}
