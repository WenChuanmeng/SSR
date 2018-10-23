package com.sr.searchroom.web.controller;

import com.sr.searchroom.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("title","欢迎欢迎");
        model.addAttribute("name","张三ABCdef123");
        return "index";
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public ApiResponse get() {
        return ApiResponse.ofMessage(200, "返回");
    }
}
