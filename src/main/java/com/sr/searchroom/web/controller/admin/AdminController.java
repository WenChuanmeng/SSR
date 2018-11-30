package com.sr.searchroom.web.controller.admin;

import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.sr.searchroom.base.ApiResponse;
import com.sr.searchroom.config.QiniuUploadConfig;
import com.sr.searchroom.entity.SupportAddress;
import com.sr.searchroom.service.IAddressService;
import com.sr.searchroom.service.IHouseService;
import com.sr.searchroom.service.IQiniuService;
import com.sr.searchroom.service.ServiceResult;
import com.sr.searchroom.web.dto.HouseDTO;
import com.sr.searchroom.web.dto.QiniuReput;
import com.sr.searchroom.web.dto.SupportAddressDTO;
import com.sr.searchroom.web.form.HouseForm;
import javassist.bytecode.analysis.MultiArrayType;
import javassist.bytecode.analysis.MultiType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by 温小萌 on 2018/11/5
 */
@Controller
public class AdminController {

    @Autowired
    private IQiniuService qiniuService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IHouseService houseService;

    @Autowired
    private Gson gson;

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
//        File file = new File("E:\\test-web\\search-room\\tmp\\" + filename);
//
//        try {
//            multipartFile.transferTo(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
//        }
        try {
            //QiniuUploadConfig.upload(multipartFile.getBytes(), filename);
            Response response = qiniuService.uploadFile(multipartFile.getInputStream());
            System.out.println(response.bodyString());
            if (response.isOK()) {
                QiniuReput qiniuReput = gson.fromJson(response.bodyString(), QiniuReput.class);
                return ApiResponse.ofSuccess(qiniuReput);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }
        return ApiResponse.ofSuccess(null);
    }

    @PostMapping("admin/add/house")
    @ResponseBody
    public ApiResponse addHouse(@Valid @ModelAttribute("form-house-add")HouseForm houseForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
        }

        if (null == houseForm.getPhotos() || null == houseForm.getCover()) {
            return ApiResponse.ofMessage(HttpStatus.BAD_REQUEST.value(), "图片不能为空");
        }

        Map<SupportAddress.Level, SupportAddressDTO> addressDTOMap = addressService.findCityAndRegion(houseForm.getCityEnName(), houseForm.getRegionEnName());
        if (addressDTOMap.entrySet().size() != 2) {
            return ApiResponse.ofMessage(HttpStatus.BAD_REQUEST.value(), "Not valid");
        }

        ServiceResult<HouseDTO> serviceResult = houseService.save(houseForm);
        if (serviceResult.isSuccess()) {
            return ApiResponse.ofSuccess(serviceResult.getResult());
        }

        return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
    }
}
