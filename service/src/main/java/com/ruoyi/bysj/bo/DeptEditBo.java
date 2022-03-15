package com.ruoyi.bysj.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;


/**
 * 医院信息管理编辑对象 dept
 *
 * @author 牟连波
 * @date 2021-05-01
 */
@Data
@ApiModel("医院信息管理编辑对象")
public class DeptEditBo {


    /** 部门id */
    @ApiModelProperty("部门id")
    private Long deptId;

    /** 负责人 */
    @ApiModelProperty("负责人")
    private String leader;

    /** 联系电话 */
    @ApiModelProperty("联系电话")
    private String phone;

    /** 邮箱 */
    @ApiModelProperty("邮箱")
    private String email;

    /** 部门状态（0正常 1停用） */
    @ApiModelProperty("部门状态（0正常 1停用）")
    private String status;

    /** 详细介绍 */
    @ApiModelProperty("详细介绍")
    private String introduce;

    /** 位置 */
    @ApiModelProperty("位置")
    private String position;

    /** 头像地址 */
    @ApiModelProperty("头像地址")
    private String picUrl;

    /** 医院等级 */
    @ApiModelProperty("医院等级")
    private Integer rank;

    /** 综合评分 */
    @ApiModelProperty("综合评分")
    private Integer star;
}
