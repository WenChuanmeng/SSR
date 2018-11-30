package com.sr.searchroom.service;

import lombok.Data;
import lombok.ToString;

/**
 * Created by 温小萌 on 2018/11/27
 */
@Data
@ToString
public class ServiceResult<T> {

    private boolean success;

    private String message;

    private T result;

    public ServiceResult(boolean success) {
        this.success = success;
    }

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ServiceResult(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }
}
