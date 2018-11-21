package com.sr.searchroom.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by 温小萌 on 2018/11/19
 */
@Data
@ToString
public class SupportAddressDTO {
    private Long id;

    @JsonProperty(value = "belong_to")
    private String belongTo;

    @JsonProperty(value = "en_name")
    private String enName;

    @JsonProperty(value = "cn_name")
    private String cnName;

    private String level;
}
