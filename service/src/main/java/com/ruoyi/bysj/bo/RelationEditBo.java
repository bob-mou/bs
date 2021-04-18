package com.ruoyi.bysj.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 家庭成员管理编辑对象 relation
 *
 * @author 牟连波
 * @date 2021-04-17
 */
@Data
@ApiModel("家庭成员管理编辑对象")
public class RelationEditBo {


    /** 患者用户姓名 */
    @TableField(exist = false)
    private String userName;

    /** 患者用户家属姓名 */
    @TableField(exist = false)
    private String familyName;

    /** 患者用户ID */
    @ApiModelProperty("患者用户ID")
    private Long userId;

    /** 家庭成员ID */
    @ApiModelProperty("家庭成员ID")
    private Long famalyId;

    /** 家庭关系 */
    @ApiModelProperty("家庭关系")
    private Integer relation;

    /** 状态 */
    @ApiModelProperty("状态")
    private String status;

    /** 注释 */
    @ApiModelProperty("注释")
    private String remark;
}
