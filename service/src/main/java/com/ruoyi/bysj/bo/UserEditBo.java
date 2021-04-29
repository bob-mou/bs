package com.ruoyi.bysj.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 患者管理编辑对象 sys_user
 *
 * @author 牟连波
 * @date 2021-04-20
 */
@Data
@ApiModel("患者管理编辑对象")
public class UserEditBo {


    /** 用户ID */
    @ApiModelProperty("用户ID")
    private Long userId;

    /** 部门ID */
    @ApiModelProperty("部门ID")
    private Long deptId;

    /** 登录账号名称 */
    @ApiModelProperty("登录账号名称")
    private String userName;

    /** 用户姓名 */
    @ApiModelProperty("用户姓名")
    private String nickName;

    /** 用户类型（00系统用户） */
    @ApiModelProperty("用户类型（00系统用户）")
    private String userType;

    /** 用户邮箱 */
    @ApiModelProperty("用户邮箱")
    private String email;

    /** 手机号码 */
    @ApiModelProperty("手机号码")
    private String phonenumber;

    /** 用户性别（0男 1女 2未知） */
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private String sex;

    /** 头像地址 */
    @ApiModelProperty("头像地址")
    private String avatar;

    /** 密码 */
    @ApiModelProperty("密码")
    private String password;

    /** 帐号状态（0正常 1停用） */
    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;

    /** 最后登录IP */
    @ApiModelProperty("最后登录IP")
    private String loginIp;

    /** 最后登录时间 */
    @ApiModelProperty("最后登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginDate;

    /** 更新者 */
    @ApiModelProperty("更新者")
    private String updateBy;

    /** 更新时间 */
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 备注 */
    @ApiModelProperty("备注")
    private String remark;

    /** 医生简介 */
    @ApiModelProperty("医生简介")
    private String introduce;
}
