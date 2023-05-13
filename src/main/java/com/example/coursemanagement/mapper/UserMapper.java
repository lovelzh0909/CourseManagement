package com.example.coursemanagement.mapper;

import com.example.coursemanagement.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WYT
 * @since 2023-05-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
