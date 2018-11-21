package com.sr.searchroom.base;

import lombok.Data;
import lombok.Getter;

/**
 * Created by 温小萌 on 2018/10/22
 */
@Data
public class ApiResponse {

    private int code;
    private String message;
    private Object data;
    private boolean more;

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse ofMessage(int code, String message) {
        return new ApiResponse(code, message, null);
    }

    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.getCode(), status.getStandardMessage(), null);
    }

    /**
     * 内部状态枚举
     */
    @Getter
    public enum Status{

        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        NOT_VALID_PARAM(50005, "Not Valid Param"),
        NOT_SUPPORTED_OPERATION(50006, "Opereation Not Supported"),
        NOT_LOGIN(60000, "Not Login");

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }
    }
}
