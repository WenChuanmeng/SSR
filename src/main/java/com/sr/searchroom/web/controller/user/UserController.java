package com.sr.searchroom.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 温小萌 on 2018/11/14
 */
@Controller
public class UserController {

    @GetMapping(value = "/user/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping(value = "/user/center")
    public String centerPage() {
        return "user/center";
    }
}
