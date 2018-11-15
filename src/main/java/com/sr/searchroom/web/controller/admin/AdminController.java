package com.sr.searchroom.web.controller.admin;

import com.sr.searchroom.base.ApiResponse;
import javassist.bytecode.analysis.MultiArrayType;
import javassist.bytecode.analysis.MultiType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by 温小萌 on 2018/11/5
 */
@Controller
public class AdminController {

    @RequestMapping(value = "admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    @RequestMapping(value = "admin/welcome")
    public String adminWelcomePage() {
        return "admin/welcome";
    }

    @RequestMapping(value = "admin/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    @GetMapping(value = "admin/add/house")
    public String adminAddHouse() {
        return "admin/house-add";
    }

    @PostMapping(value = "admin/upload/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ApiResponse adminUploadPhoto(@RequestParam("file")MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }

        String filename = multipartFile.getOriginalFilename();
        File file = new File("E:\\test-web\\search-room\\tmp\\" + filename);

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }
        return ApiResponse.ofSuccess(null);
    }
}
