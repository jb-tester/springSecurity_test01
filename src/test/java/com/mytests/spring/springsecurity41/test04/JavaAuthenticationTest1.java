package com.mytests.spring.springsecurity41.test04;

import com.mytests.spring.springsecurity41.test01.TestBean1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 7/1/2016.
 * Project: test04
 * *******************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig1.class)
public class JavaAuthenticationTest1 {

    @Autowired
    private TestBean1 infoLogger;

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testUnauthenticated() {
        infoLogger.showAuthInfo();
    }

    @Test
    @WithUserDetails(value = "irina", userDetailsServiceBeanName = "ud")
    public void testWithUserDetails() {
        System.out.println(infoLogger.showAuthInfo());
        User user = (User) infoLogger.getAuthentication().getPrincipal();
        SimpleGrantedAuthority[] authorities = new SimpleGrantedAuthority[3];
        authorities[0] = new SimpleGrantedAuthority("ROLE_ADMIN");
        authorities[1] = new SimpleGrantedAuthority("ROLE_USER");
        authorities[2] = new SimpleGrantedAuthority("ROLE_BAR");
        Assert.assertArrayEquals(user.getAuthorities().toArray(),authorities);
    }
}
