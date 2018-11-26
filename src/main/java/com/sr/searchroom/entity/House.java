package com.sr.searchroom.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 温小萌 on 2018/11/26
 */
@Data
@ToString
@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;

    private Integer area;

    private Integer room;

    private Integer floor;

    @Column(name = "total_floor")
    private Integer totalFloor;

    @Column(name = "watch_times")
    private Integer watchTimes;

    @Column(name = "build_year")
    private Integer buildYear;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Column(name = "city_en_name")
    private String cityEnName;

    @Column(name = "region_en_name")
    private String regionEnName;

    private String cover;

    private Integer direction;

    @Column(name = "distance_to_subway")
    private Integer distanceToSubway;

    private Integer parlour;

    private String district;

    @Column(name = "admin_id")
    private Long adminId;

    private Integer bathroom;

    private String street;

}
