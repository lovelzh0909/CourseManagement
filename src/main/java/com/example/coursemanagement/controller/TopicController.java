package com.example.coursemanagement.controller;


import com.example.coursemanagement.response.CommonReturnType;
import com.example.coursemanagement.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/get")
    public CommonReturnType getTopic(){
        return CommonReturnType.create(topicService.list(null));
    }

}

