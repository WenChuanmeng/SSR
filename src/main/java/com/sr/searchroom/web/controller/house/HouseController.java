package com.sr.searchroom.web.controller.house;

import com.sr.searchroom.base.ApiResponse;
import com.sr.searchroom.service.IAddressService;
import com.sr.searchroom.service.ServiceMultiResult;
import com.sr.searchroom.web.dto.SubwayDTO;
import com.sr.searchroom.web.dto.SubwayStationDTO;
import com.sr.searchroom.web.dto.SupportAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 温小萌 on 2018/11/19
 */
@Controller
public class HouseController {

    @Autowired
    private IAddressService addressService;

    /**
     * 获取城市信息
     * @return
     */
    @GetMapping(value = "address/support/cities")
    @ResponseBody
    public ApiResponse addressSupportCities() {

        ServiceMultiResult<SupportAddressDTO> supportAddresses = addressService.getSupportCities();
        if (null == supportAddresses || supportAddresses.getResultSize() == 0) {

            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(supportAddresses.getResult());
    }

    /**
     * 获取城市下地区的信息
     * @param cityName
     * @return
     */
    @GetMapping(value = "address/support/regions")
    @ResponseBody
    public ApiResponse addressSupportRegions(@RequestParam(name = "city_name")String cityName) {

        ServiceMultiResult<SupportAddressDTO> result = addressService.getSupportRegions(cityName);

        if (null == result || result.getResultSize() == 0 ) {
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }

        return ApiResponse.ofSuccess(result.getResult());
    }

    /**
     * 获取城市的地铁线路
     * @param cityName
     * @return
     */
    @GetMapping(value = "address/support/subway/line")
    @ResponseBody
    private ApiResponse subwayLies(@RequestParam(name = "city_name")String cityName) {
        ServiceMultiResult<SubwayDTO> subways = addressService.getSubways(cityName);
        if (null == subways || subways.getResultSize() == 0) {
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(subways.getResult());
    }

    /**
     * 获取地铁站
     * @param subwayId
     * @return
     */
    @GetMapping(value = "address/support/subway/station")
    @ResponseBody
    public ApiResponse subwayStations(@RequestParam(name = "subway_id")Long subwayId) {

        ServiceMultiResult<SubwayStationDTO> subwayStations = addressService.getSubwayStations(subwayId);
        if (null == subwayStations || subwayStations.getResultSize() == 0) {
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(subwayStations.getResult());
    }
}
