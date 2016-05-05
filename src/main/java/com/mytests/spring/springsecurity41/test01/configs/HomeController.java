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
public class HomeController {
    @RequestMapping("/home")
    public String home(ModelMap model) {
        model.addAttribute("home_attr1", "home_attr1");
        return "home";
    }
}
