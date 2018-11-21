package com.sr.searchroom.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by 温小萌 on 2018/11/21
 */
@Data
@ToString
@Table(name = "subway_station")
@Entity
public class SubwayStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subway_id")
    private Long subwayId;

    private String name;
}
