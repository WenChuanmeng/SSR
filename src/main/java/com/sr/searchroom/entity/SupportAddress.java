package com.sr.searchroom.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by 温小萌 on 2018/11/19
 */
@Entity
@Data
@ToString
@Table(name = "support_address")
public class SupportAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 上级行政单位
     */
    @Column(name = "belong_to")
    private String belongTo;

    @Column(name = "en_name")
    private String enName;

    @Column(name = "cn_name")
    private String cnName;

    @Column(name = "level")
    private String level;

    @Column(name = "baidu_map_lng")
    private Double baiduMaplng;

    @Column(name = "baidu_map_lat")
    private Double baiduMapLat;

    public enum  Level {
        CITY("city"),
        REGION("region");

        private String value;

        Level(String value) {
            this.value = value;
        }

        public String getValue(){
            return value;
        }

        public static Level of(String value) {
            for (Level level : Level.values()) {
                if (level.getValue().equals(value)) {
                    return level;
                }
            }
            throw new IllegalArgumentException();
        }

    }
}
