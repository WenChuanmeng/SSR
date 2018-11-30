package com.sr.searchroom.web.form;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by 温小萌 on 2018/11/27
 */
@Data
@ToString
public class HouseForm {

    private Long id;

    @NotNull(message = "大标题不能为空！")
    @Size(min = 1, max = 30, message = "标题长度必须在1-30之间！")
    private String title;

    @NotNull(message = "城市不能为空！")
    @Size(min = 1, message = "城市非法！")
    private String cityEnName;

    @NotNull(message = "地区不能为空！")
    @Size(min = 1, message = "地区非法！")
    private String regionEnName;

    @NotNull(message = "街道不能为空！")
    @Size(min = 1, message = "街道非法！")
    private String street;

    @NotNull(message = "小区不能为空！")
    private String district;

    @NotNull(message = "详细地址不能为空！")
    @Size(min = 1, max = 30, message = "详细地址长度在1-30之间")
    private String detailAddress;

    @NotNull(message = "卧室数量不能为空")
    @Min(value = 1, message = "卧室数量非法")
    private Integer room;

    private Integer parlour;//厅

    @NotNull(message = "所在楼层数不能为空")
    private Integer floor;

    @NotNull(message = "总楼层数不能为空")
    private Integer totalFloor;

    @NotNull(message = "房屋朝向不能为空")
    private Integer direction;

    @NotNull(message = "建筑时间不能为空")
    @Min(value = 1900, message = "建筑时间非法")
    private Integer buildYear;

    @NotNull(message = "出租面积不能为空")
    @Min(value = 1, message = "面积非法")
    private Integer area;

    @NotNull(message = "租赁价格不能为空")
    @Min(value = 1, message = "租赁价格非法")
    private Integer price;

    @NotNull(message = "租赁方式不能为空")
    @Min(value = 0)
    @Max(value = 1)
    private Integer rentWay;

    private Long subwayLineId;

    private Long subwayStationId;

    private Integer distanceToSubway = -1;

    private String layoutDesc;

    private String roundService;

    private String traffic;

    @Size(max = 255)
    private String description;

    private String cover;

    private List<String> tags;

    private List<PhotoForm> photos;
}
