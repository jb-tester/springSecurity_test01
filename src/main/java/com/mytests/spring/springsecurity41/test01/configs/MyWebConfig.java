package com.mytests.spring.springsecurity41.test01.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/27/2016.
 * Project: test01
 * *******************************
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class MyWebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();
        super.configureViewResolvers(registry);
    }
}
