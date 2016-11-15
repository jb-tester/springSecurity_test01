package com.mytests.spring.springsecurity41.test04;

import com.mytests.spring.springsecurity41.test01.TestBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.*;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 7/1/2016.
 * Project: test04
 * *******************************
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class TestConfig1 extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(
            AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().getUserDetailsService();

    }
    @Override
    protected void configure(
            HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login?expired")
        ;
    }

    @Bean(name = "ud")
    public UserDetailsService userDetails() {


        List<UserDetails> users = new ArrayList<>();
        List<SimpleGrantedAuthority> irina_authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_FOO"));
        List<SimpleGrantedAuthority> admin_authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        users.add(new User("irina","jolt", irina_authorities));
        users.add(new User("admin","admin", admin_authorities));
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public TestBean1 infoLogger() {
        return new TestBean1();
    }
}
