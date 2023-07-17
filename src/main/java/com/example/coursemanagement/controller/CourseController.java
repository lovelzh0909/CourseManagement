package com.example.coursemanagement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.coursemanagement.entity.Course;
import com.example.coursemanagement.entity.User;
import com.example.coursemanagement.entity.UserRelCourse;
import com.example.coursemanagement.service.CourseService;
import com.example.coursemanagement.service.UserRelCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WYT
 * @since 2023-04-13
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final UserRelCourseService userRelCourseService;
    @Autowired
    public CourseController(CourseService courseService,UserRelCourseService userRelCourseService){
        this.courseService=courseService;
        this.userRelCourseService=userRelCourseService;
    }
    @GetMapping("/get")
    public List<Course> getCourse(){
        return courseService.list(null);
    }

    @PostMapping("/collect")
    public List<Course> getCollectedCourse(@RequestBody User user){
        List<Course> newList = new ArrayList<>();
        List<Course> oldList = courseService.list(null);
        for(Course course:oldList){
            UserRelCourse one = userRelCourseService.getOne(new QueryWrapper<UserRelCourse>()
                    .eq("course_id", course.getId())
                    .eq("user_id",user.getId()));
            if(one!=null){
                newList.add(course);
            }
        }
        return newList;
    }

    @PostMapping("/classify")
    public List<Course> getCollectedCourse(@RequestBody Course course1){
        String type = course1.getType();
        List<Course> newList = new ArrayList<>();
        List<Course> oldList = courseService.list(null);
        for(Course course:oldList){
            if(Objects.equals(type,course.getType())){
                newList.add(course);
            }
        }
        return newList;
    }
}

