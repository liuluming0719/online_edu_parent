package com.llm.eduservice.controller;


import com.llm.eduservice.entity.EduChapter;
import com.llm.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author LiuLuMing
 * @since 2021-06-26
 */
@Api(description = "章节模块")
@RestController
@RequestMapping("/eduservice/edu-chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    @ApiOperation(value = "获取章节列表")
    @GetMapping("findAll")
    public List<EduChapter> findAll() {
        return eduChapterService.list(null);
    }
}

