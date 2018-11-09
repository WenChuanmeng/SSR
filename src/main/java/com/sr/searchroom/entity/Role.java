package com.sr.searchroom.entity;

import lombok.Data;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by 温小萌 on 2018/11/9
 */
@Data
@ToString
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String name;
}
