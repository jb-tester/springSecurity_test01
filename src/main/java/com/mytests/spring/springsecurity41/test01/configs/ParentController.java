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
@RequestMapping("/important")
public class ParentController {
    @RequestMapping("/secret1")
    public String secret1(ModelMap model) {
        model.addAttribute("secret1_attr1", "secret1_attr1");
        return "secret_page1";
    }
    @RequestMapping("/secret2")
    public String secret2(ModelMap model) {
        model.addAttribute("secret2_attr1", "secret2_attr1");
        return "secret_page2";
    }
}
