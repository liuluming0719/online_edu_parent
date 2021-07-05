package com.llm.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.eduservice.entity.EduTeacher;
import com.llm.eduservice.entity.vo.TeacherQuery;
import com.llm.eduservice.service.EduTeacherService;
import com.llm.servicebase.enums.ExceptionEnum;
import com.llm.servicebase.exception.EduException;
import com.llm.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author LiuLuMing
 * @since 2021-06-26
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "查询讲师列表")
    @GetMapping("findAll")
    public ResultVo findAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return ResultVo.success().data("items",list);
    }

    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("delete/{id}")
    public ResultVo deleteTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)@PathVariable String id) {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw new EduException(ExceptionEnum.SYSTEM_ERROR.getCode(),ExceptionEnum.SYSTEM_ERROR.getMsg());
        }
        boolean flag = eduTeacherService.removeById(id);
        if (flag) {
            return ResultVo.success();
        } else {
            return ResultVo.error();
        }
    }

    @ApiOperation(value = "分页查询教师列表")
    @GetMapping("getTeacherByPage/{current}/{limit}")
    public ResultVo getTeacherByPage(@PathVariable long current,
                                     @PathVariable long limit) {
        //创建page对象
        Page<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page,null);
        //总条数
        long total = page.getTotal();
        //数据list集合
        List<EduTeacher> records = page.getRecords();
        return ResultVo.success().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "条件分页查询")
    @PostMapping("page/{current}/{limit}")
    public ResultVo page(@PathVariable long current,
                                     @PathVariable long limit,
                                     @RequestBody TeacherQuery teacherQuery) {
        //创建page对象
        Page<EduTeacher> page = new Page<>(current,limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(teacherQuery.getName()),"name",teacherQuery.getName());
        wrapper.eq(!StringUtils.isEmpty(teacherQuery.getLevel()),"level",teacherQuery.getLevel());
        wrapper.ge(!StringUtils.isEmpty(teacherQuery.getBegin()) ,"gmt_create",teacherQuery.getBegin());
        wrapper.le(!StringUtils.isEmpty(teacherQuery.getEnd()),"gmt_create",teacherQuery.getEnd());
        eduTeacherService.page(page,wrapper);
        //总条数
        long total = page.getTotal();
        //数据list集合
        List<EduTeacher> records = page.getRecords();
        return ResultVo.success().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "更新讲师")
    @PutMapping("update")
    public ResultVo updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag) {
            return ResultVo.success();
        } else {
            return ResultVo.error();
        }
    }

    @ApiOperation(value = "添加讲师信息")
    @PostMapping("save")
    public ResultVo addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return ResultVo.success();
        } else {
            return ResultVo.error();
        }
    }

    @ApiOperation(value = "根据讲师id查询")
    @GetMapping("teacher/{id}")
    public ResultVo getById(@PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return ResultVo.success().data("item",eduTeacher);
    }
}

