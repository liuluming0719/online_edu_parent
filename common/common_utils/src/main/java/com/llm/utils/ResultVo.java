package com.llm.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 统一返回结果工具类
 * @author: LiuLuMing
 * @createtime: 2021-06-27 12:43
 */
@Data
public class ResultVo {

    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<>();


    //构造方法私有
    private ResultVo() {
    }

    public ResultVo success(boolean success) {
        this.success = success;
        return this;
    }

    public ResultVo code(Integer code) {
        this.code = code;
        return this;
    }

    public ResultVo message(String message) {
        this.message = message;
        return this;
    }

    public ResultVo data(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public ResultVo data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    //成功静态方法
    public static ResultVo success() {
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        resultVo.setCode(ConstantUtil.RESULT_SUCCESS_CODE);
        resultVo.setMessage("操作成功");
        return resultVo;
    }

    //失败的静态方法
    public static ResultVo error() {
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setCode(ConstantUtil.RESULT_ERROR_CODE);
        resultVo.setMessage("操作失败");
        return resultVo;
    }
}
