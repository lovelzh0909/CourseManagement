package com.example.coursemanagement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.coursemanagement.entity.Topic;
import com.example.coursemanagement.entity.User;
import com.example.coursemanagement.frontdata.TopicInfo;
import com.example.coursemanagement.response.CommonReturnType;
import com.example.coursemanagement.service.TopicService;
import com.example.coursemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WYT
 * @since 2023-04-13
 */
@RestController
@RequestMapping("/topic")
public class TopicController {
    private final TopicService topicService;
    private final UserService userService;

    @Autowired
    public TopicController(TopicService topicService,UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<TopicInfo> getTopic(){
        List<Topic>backList=topicService.list(null);
        List<TopicInfo>frontList=new ArrayList<>();
        for(Topic t:backList){
            User one = userService.getOne(
                    new QueryWrapper<User>()
                            .eq("id", t.getUserId()));
            TopicInfo f=new TopicInfo(t.getTopicName(),t.getTopicContent(),one.getName(),one.getRole());
            frontList.add(f);
        }
        return frontList;
    }
}

