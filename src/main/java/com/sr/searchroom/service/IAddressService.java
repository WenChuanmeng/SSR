package com.sr.searchroom.service;

import com.sr.searchroom.entity.SupportAddress;
import com.sr.searchroom.web.dto.SubwayDTO;
import com.sr.searchroom.web.dto.SubwayStationDTO;
import com.sr.searchroom.web.dto.SupportAddressDTO;

import java.util.Map;

/**
 * Created by 温小萌 on 2018/11/19
 */
public interface IAddressService {

    /**
     * 获取城市信息
     * @return
     */
    public ServiceMultiResult<SupportAddressDTO> getSupportCities();

    /**
     * 获取城市下地区的信息
     * @param cityName
     * @return
     */
    ServiceMultiResult<SupportAddressDTO> getSupportRegions(String cityName);

    /**
     * 获取地铁线信息
     * @param cityName
     * @return
     */
    ServiceMultiResult<SubwayDTO> getSubways(String cityName);

    /**
     * 获取地铁站信息
     * @param subwayId
     * @return
     */
    ServiceMultiResult<SubwayStationDTO> getSubwayStations(Long subwayId);

    /**
     * 用于判断输入的数据是否正确
     * @param cityEnName
     * @param regionEnName
     * @return
     */
    Map<SupportAddress.Level,SupportAddressDTO> findCityAndRegion(String cityEnName, String regionEnName);
}
