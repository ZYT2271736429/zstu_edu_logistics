package com.zstu.edu.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码加密解密
 * @author ThinkPad
 */
@Component
public class BCryptPasswordEncoderUtil extends BCryptPasswordEncoder {

    /**
     * 加密
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

    /**
     * 比对
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return super.matches(rawPassword,encodedPassword);
    }

}
