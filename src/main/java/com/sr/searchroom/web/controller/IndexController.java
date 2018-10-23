package com.sr.searchroom.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/index")
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("title","欢迎欢迎");
        model.addAttribute("name","张三ABCdef123");
        return "index";
    }
}
