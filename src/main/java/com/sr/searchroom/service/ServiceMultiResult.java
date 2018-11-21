package com.sr.searchroom.service;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 通用结果集
 * Created by 温小萌 on 2018/11/21
 */
@Data
@ToString
public class ServiceMultiResult<T> {
    private int total;
    private List<T> result;

    public ServiceMultiResult() {
    }

    public ServiceMultiResult(int total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public int getResultSize() {
        if (null == this.result) {
            return 0;
        }

        return this.result.size();
    }
}
