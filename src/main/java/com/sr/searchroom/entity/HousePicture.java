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
@Table(name = "house_picture")
public class HousePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "cdn_prefix")
    private String cdnPrefix;

    private Integer width;

    private Integer height;

    private String location;

    private String path;
}
