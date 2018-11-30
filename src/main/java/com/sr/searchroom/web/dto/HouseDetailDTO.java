package com.sr.searchroom.web.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

/**
 * Created by 温小萌 on 2018/11/27
 */
@Data
@ToString
public class HouseDetailDTO {

    private Long id;

    private String description;

    private String layoutDesc;

    private String traffic;

    private String roundService;

    private Integer rentWay;

    private String address;

    private Long subwayLineId;

    private String subwayLineName;

    private Long subwayStationId;

    private String subwayStationName;
}
