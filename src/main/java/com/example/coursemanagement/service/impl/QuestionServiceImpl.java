package com.example.coursemanagement.service.impl;

import com.example.coursemanagement.entity.Question;
import com.example.coursemanagement.mapper.QuestionMapper;
import com.example.coursemanagement.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WYT
 * @since 2023-04-13
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
