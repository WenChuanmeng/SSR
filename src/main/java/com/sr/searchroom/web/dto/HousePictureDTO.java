package com.sr.searchroom.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by 温小萌 on 2018/11/27
 */
@Data
@ToString
public class HousePictureDTO {
    private Long id;

    @JsonProperty(value = "house_id")
    private Long houseId;

    private String path;

    @JsonProperty(value = "cdn_prefix")
    private String cdnPrefix;

    private int width;

    private int height;
}
