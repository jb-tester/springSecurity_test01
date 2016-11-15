package com.mytests.spring.springsecurity41.test01;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 7/1/2016.
 * Project: test04
 * *******************************
 */
public class TestBean1 {
    @PreAuthorize("authenticated")
    public String showAuthInfo() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return "======" + authentication;
    }
    @PreAuthorize("authenticated")
    public Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return authentication;
    }
    @PreAuthorize("hasRole('ADMIN')")
    public Authentication getAdminAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return authentication;
    }
}
