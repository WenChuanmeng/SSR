package com.sr.searchroom.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by 温小萌 on 2018/11/21
 */
@Data
@ToString
public class SubwayDTO {

    private Long id;

    private String name;

    @JsonProperty(value = "city_en_name")
    private String cityEnName;
}
