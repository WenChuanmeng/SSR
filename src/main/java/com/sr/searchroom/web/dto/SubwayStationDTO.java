package com.sr.searchroom.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

/**
 * Created by 温小萌 on 2018/11/21
 */
@Data
@ToString
public class SubwayStationDTO {
    private Long id;

    @JsonProperty(value = "subway_id")
    private Long subwayId;

    private String name;
}
