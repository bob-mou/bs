package com.ruoyi.bysj.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;

/**
 * 医院信息管理对象 dept
 *
 * @author 牟连波
 * @date 2021-05-01
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_dept")
public class Dept implements Serializable {

private static final long serialVersionUID=1L;


    /** 部门id */
    @TableId(value = "dept_id")
    private Long deptId;

    /** 父部门id */
    private Long parentId;

    /** 祖级列表 */
    private String ancestors;

    /** 部门名称 */
    private String deptName;

    /** 显示顺序 */
    private Integer orderNum;

    /** 负责人 */
    private String leader;

    /** 联系电话 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 部门状态（0正常 1停用） */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @TableLogic
    private String delFlag;

    /** 详细介绍 */
    private String introduce;

    /** 位置 */
    private String position;

    /** 头像地址 */
    private String picUrl;

    /** 医院等级 */
    private String rank;

    /** 综合评分 */
    private Integer star;

    /** 订单数量 */
    private Integer oderNum;

        /** 创建者 */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /** 更新者 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
