package com.sr.searchroom.web.controller;

import com.sr.searchroom.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("title","欢迎欢迎");
        //model.addAttribute("name","张三ABCdef123");
        return "index";
    }

    /**
     * demo
     * @return
     */
    @GetMapping(value = "/get")
    @ResponseBody
    public ApiResponse get() {
        return ApiResponse.ofMessage(200, "返回");
    }

    /**
     * 500
     * @return
     */
    @RequestMapping(value = "/500")
    public String errorPage() {
        return "500";
    }

    /**
     * 403
     * @return
     */
    @RequestMapping(value = "/403")
    public String forbidden() {
        return "403";
    }

    /**
     * 400
     * @return
     */
    @RequestMapping(value = "/400")
    public String badRequest() {
        return "400";
    }

    /**
     * 登出页面
     * @return
     */
    @RequestMapping(value = "/loginout")
    public String loginout() {
        return "loginout";
    }
}
