package com.rnproject.responsebean;

import java.util.Scanner;

/**
 * Created by mark on 17-1-16.
 */
public class BaseResponse {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
