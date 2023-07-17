package com.example.coursemanagement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.coursemanagement.entity.User;
import com.example.coursemanagement.entity.UserRelCourse;
import com.example.coursemanagement.response.CommonReturnType;
import com.example.coursemanagement.service.UserRelCourseService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WYT
 * @since 2023-04-13
 */
@RestController
@RequestMapping("/user-rel-course")
public class UserRelCourseController {
    private final UserRelCourseService userRelCourseService;
    @Autowired
    public UserRelCourseController(UserRelCourseService userRelCourseService){
        this.userRelCourseService = userRelCourseService;
    }

    @PostMapping("/build")
    public CommonReturnType relBuild(@RequestBody UserRelCourse userRelCourse){
        UserRelCourse one = userRelCourseService.getOne(
                new QueryWrapper<UserRelCourse>()
                        .eq("user_id", userRelCourse.getUserId())
                        .eq("course_id", userRelCourse.getCourseId()));
        if(one != null){
            userRelCourseService.removeById(one.getId());
            return CommonReturnType.create(null,"取消成功");
        }
        else{
            if(userRelCourse.getUserId()!=null && userRelCourse.getCourseId()!=null){
                userRelCourseService.save(userRelCourse);
            }
        }
        return CommonReturnType.create(null,"收藏成功");
    }
}

