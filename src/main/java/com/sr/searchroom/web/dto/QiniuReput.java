package com.sr.searchroom.web.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Created by 温小萌 on 2018/11/16
 */
@Data
@ToString
public class QiniuReput {
    private String key;
    private String hash;
    private String bucket;
    private int width;
    private int height;
}
