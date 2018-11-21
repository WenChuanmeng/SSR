package com.sr.searchroom.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by 温小萌 on 2018/11/21
 */
@Data
@ToString
@Entity
@Table(name = "subway")
public class Subway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private String name;

     @Column(name = "city_en_name")
     private String cityEnName;
}
