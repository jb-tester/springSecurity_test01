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
@ContextConfiguration(locations = "classpath*:testConfig1.xml")
public class XMLAuthenticationTest1 {
    @Autowired
    private TestBean1 infoLogger;

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testUnauthenticated() {
        infoLogger.showAuthInfo();
    }

    @Test
    @WithUserDetails(userDetailsServiceBeanName = "inMemoryUserDetailsManager", value = "irina")
    public void testWithUserDetailsInMemory() {
        System.out.println(infoLogger.showAuthInfo());
        User user = (User) infoLogger.getAuthentication().getPrincipal();
        SimpleGrantedAuthority[] authorities = new SimpleGrantedAuthority[2];
        authorities[0] = new SimpleGrantedAuthority("ROLE_ADMIN");
        authorities[1] = new SimpleGrantedAuthority("ROLE_USER");
        Assert.assertArrayEquals(user.getAuthorities().toArray(),authorities);
    }

    @Test
    @WithUserDetails(userDetailsServiceBeanName = "jdbcUserDetailsManager", value = "foo")
    public void testWithUserDetailsJdbc() {
        System.out.println(infoLogger.showAuthInfo());
        User user = (User) infoLogger.getAuthentication().getPrincipal();
        SimpleGrantedAuthority[] authorities = new SimpleGrantedAuthority[1];

        authorities[0] = new SimpleGrantedAuthority("ROLE_FOO");
        Assert.assertArrayEquals(user.getAuthorities().toArray(),authorities);
    }
}
