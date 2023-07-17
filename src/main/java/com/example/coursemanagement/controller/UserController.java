package com.example.coursemanagement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.coursemanagement.entity.User;
import com.example.coursemanagement.response.AvatarReturnType;
import com.example.coursemanagement.response.CommonReturnType;
import com.example.coursemanagement.service.UserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WYT
 * @since 2023-05-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public CommonReturnType login(@RequestBody User user) {
        User one = userService.getOne(
                new QueryWrapper<User>()
                        .eq("phone", user.getPhone())
                        .eq("password", user.getPassword()));

        if(one!=null){
            return CommonReturnType.create(one.getId());
        }
        return CommonReturnType.create(null,"用户名或密码错误");
    }

    @PostMapping("/register")
    public CommonReturnType register(@RequestBody User user){
        User one = userService.getOne(new QueryWrapper<User>().eq("phone", user.getPhone()));
        if(one!=null){
            return CommonReturnType.create(null,"用户名已存在");
        }
        else {
            if(StringUtils.isEmptyOrWhitespaceOnly(user.getPhone()) || StringUtils.isEmptyOrWhitespaceOnly(user.getPassword())){
                return CommonReturnType.create(null,"用户名或密码不能为空");
            }
            else{
                userService.save(user);
            }
        }
        return CommonReturnType.create(null);
    }

    @PostMapping("/avatar")
    public AvatarReturnType getAvatar(@RequestBody User user){
        User one = userService.getOne((new QueryWrapper<User>().eq("id",user.getId())));
        return AvatarReturnType.create(one.getRole());
    }
}

