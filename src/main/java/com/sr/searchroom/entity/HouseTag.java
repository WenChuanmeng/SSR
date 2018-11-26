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
@Table(name = "house_tag")
public class HouseTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    private String name;
}
