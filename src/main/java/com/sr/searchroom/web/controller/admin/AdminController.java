package com.sr.searchroom.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 温小萌 on 2018/11/5
 */
@Controller
public class AdminController {

    @RequestMapping(value = "admin/center")
    public String adminCenter() {
        return "admin/center";
    }

    @RequestMapping(value = "admin/welcome")
    public String adminWelcome() {
        return "admin/welcome";
    }
}
