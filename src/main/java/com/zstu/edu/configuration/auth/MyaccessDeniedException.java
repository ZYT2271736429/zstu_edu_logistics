package com.zstu.edu.configuration.auth;

import org.springframework.security.access.AccessDeniedException;

/**
 * @author ThinkPad
 */
public class MyaccessDeniedException extends AccessDeniedException {


    public MyaccessDeniedException(String msg) {
        super(msg);
    }
}
