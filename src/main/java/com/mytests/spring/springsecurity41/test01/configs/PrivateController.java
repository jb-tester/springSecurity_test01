package com.mytests.spring.springsecurity41.test01.configs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/29/2016.
 * Project: test01
 * *******************************
 */
@Controller
@RequestMapping("/private")
public class PrivateController {
    @RequestMapping("/private1")
    public String private1(ModelMap model) {
        model.addAttribute("private1_attr1", "private1_attr1");
        return "private_page1";
    }
}
