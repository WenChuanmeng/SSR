package com.sr.searchroom.web.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * Created by 温小萌 on 2018/11/27
 */
@Data
@ToString
public class HouseDTO {

    private Long id;

    private String title;

    private Integer price;

    private Integer area;

    private Integer room;

    private Integer floor;

    private Integer totalFloor;

    private Integer watchTimes;

    private Integer buildYear;

    private Integer status;

    private Date createTime;

    private Date lastUpdateTime;

    private String cityEnName;

    private String regionEnName;

    private String cover;

    private Integer direction;

    private Integer distanceToSubway;

    private Integer parlour;

    private String district;

    private Long adminId;

    private Integer bathroom;

    private String street;

    private HouseDetailDTO houseDetail;

    private List<String> tags;

    private List<HousePictureDTO> pictures;

    private int subscribeStatus;
}
