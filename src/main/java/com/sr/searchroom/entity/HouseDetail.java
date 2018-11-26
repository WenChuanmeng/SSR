package com.sr.searchroom.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by 温小萌 on 2018/11/26
 */
@Data
@ToString
@Entity
@Table(name = "house_detail")
public class HouseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "layout_desc")
    private String layoutDesc;

    private String traffic;

    @Column(name = "round_service")
    private String roundService;

    @Column(name = "rent_way")
    private Integer rentWay;

    private String address;

    @Column(name = "subway_line_id")
    private Long subwayLineId;

    @Column(name = "subway_line_name")
    private String subwayLineName;

    @Column(name = "subway_station_id")
    private Long subwayStationId;

    @Column(name = "subway_station_name")
    private String subwayStationName;

    @Column(name = "house_id")
    private Long houseId;
}
