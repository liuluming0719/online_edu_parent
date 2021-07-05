package com.llm.servicebase.exception;

import com.llm.servicebase.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 自定义异常
 * @author: LiuLuMing
 * @createtime: 2021-06-27 18:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduException extends RuntimeException{

    //状态码
    private Integer code;

    //返回信息
    private String msg;

    public EduException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public EduException(ExceptionEnum exceptionEnum,String msg) {
        this.code = exceptionEnum.getCode();
        this.msg = msg;
    }
}
