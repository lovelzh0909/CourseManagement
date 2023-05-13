package com.example.coursemanagement.service.impl;

import com.example.coursemanagement.entity.User;
import com.example.coursemanagement.mapper.UserMapper;
import com.example.coursemanagement.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WYT
 * @since 2023-05-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
