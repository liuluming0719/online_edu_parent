package com.llm.servicebase.enums;

/**
 * @description: 枚举：异常状态信息封装
 * @author: LiuLuMing
 * @createtime: 2021-06-27 18:30
 */
public enum ExceptionEnum {

    SYSTEM_ERROR(500,"系统错误");

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
