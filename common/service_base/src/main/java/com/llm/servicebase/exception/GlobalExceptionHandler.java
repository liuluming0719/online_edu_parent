package com.llm.servicebase.exception;

import com.llm.utils.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 异常处理
 * @author: LiuLuMing
 * @createtime: 2021-06-27 18:23
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultVo error(Exception e) {
        e.printStackTrace();
        return ResultVo.error().message("执行的是全局异常");
    }

    @ExceptionHandler(EduException.class)
    public ResultVo error(EduException e) {
        log.error(e.getMsg());
        e.printStackTrace();
        return ResultVo.error().code(e.getCode()).message(e.getMsg());
    }
}
