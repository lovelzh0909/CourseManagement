package com.example.coursemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author WYT
 * @since 2023-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer courseId;

    private String content;

    private String choiceA;

    private String choiceB;

    private String choiceC;

    private String choiceD;

    private String answer;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private Integer pointId;

    private Integer difficultyDegree;

    @Version
    private Integer version;


}
