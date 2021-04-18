package com.ruoyi.bysj.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;

/**
 * 家庭成员管理对象 relation
 *
 * @author 牟连波
 * @date 2021-04-17
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("relation")
public class Relation implements Serializable {

private static final long serialVersionUID=1L;


    /** 患者用户ID */
    @TableId(value = "user_id")
    private Long userId;

    /** 家庭成员ID */
    private Long famalyId;

    /** 家庭关系 */
    private Integer relation;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    /** 状态 */
    private String status;

    /** 注释 */
    private String remark;

    /** 患者用户姓名 */
    @TableField(exist = false)
    private String userName;

    /** 患者用户家属姓名 */
    @TableField(exist = false)
    private String familyName;

}
