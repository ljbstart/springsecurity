package com.yangxu.security.pojo.vo.rest;


import lombok.Data;

@Data
public class ResultObject<T> {
    private int code;
    private String msg;
    private T data;

    public ResultObject() {
    }

    public ResultObject(int code) {
        if (code == 0) {
            this.code = ResultCodeEnum.SUCCESS.getCode();
            this.msg = ResultCodeEnum.SUCCESS.getMsg();
        } else {
            this.code = ResultCodeEnum.getEnumById(code).getCode();
            this.msg = ResultCodeEnum.getEnumById(code).getMsg();
        }

    }

    public ResultObject(int code, T obj) {
        if (code == 0) {
            this.code = ResultCodeEnum.SUCCESS.getCode();
            this.msg = ResultCodeEnum.SUCCESS.getMsg();
            this.data = obj;
        } else {
            this.code = ResultCodeEnum.getEnumById(code).getCode();
            this.msg = ResultCodeEnum.getEnumById(code).getMsg();
            this.data = obj;
        }

    }

    public static ResultObject getInstance() {
        return new ResultObject(0);
    }

    public static ResultObject illegalArgument() {
        return new ResultObject(4000);
    }

    public static ResultObject data(Object data) {
        return new ResultObject(0, data);
    }

}
