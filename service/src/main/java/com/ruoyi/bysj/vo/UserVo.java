package com.ruoyi.bysj.vo;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 患者管理视图对象 mall_package
 *
 * @author 牟连波
 * @date 2021-04-20
 */
@Data
@ApiModel("患者管理视图对象")
public class UserVo {
	private static final long serialVersionUID = 1L;

	/** 用户ID */
	@Excel(name = "用户ID")
	@ApiModelProperty("用户ID")
	private Long userId;
	/** 部门ID */
	@Excel(name = "部门ID")
	@ApiModelProperty("部门ID")
	private Long deptId;
	/** 登录账号名称 */
	@Excel(name = "登录账号名称")
	@ApiModelProperty("登录账号名称")
	private String userName;
	/** 用户姓名 */
	@Excel(name = "用户姓名")
	@ApiModelProperty("用户姓名")
	private String nickName;
	/** 用户类型（00系统用户） */
	@Excel(name = "用户类型" , readConverterExp = "0=0系统用户")
	@ApiModelProperty("用户类型（00系统用户）")
	private String userType;
	/** 用户邮箱 */
	@Excel(name = "用户邮箱")
	@ApiModelProperty("用户邮箱")
	private String email;
	/** 手机号码 */
	@Excel(name = "手机号码")
	@ApiModelProperty("手机号码")
	private String phonenumber;
	/** 用户性别（0男 1女 2未知） */
	@Excel(name = "用户性别" , readConverterExp = "0=男,1=女,2=未知")
	@ApiModelProperty("用户性别（0男 1女 2未知）")
	private String sex;
	/** 头像地址 */
	@Excel(name = "头像地址")
	@ApiModelProperty("头像地址")
	private String avatar;
	/** 密码 */
	@Excel(name = "密码")
	@ApiModelProperty("密码")
	private String password;
	/** 帐号状态（0正常 1停用） */
	@Excel(name = "帐号状态" , readConverterExp = "0=正常,1=停用")
	@ApiModelProperty("帐号状态（0正常 1停用）")
	private String status;
	/** 最后登录IP */
	@Excel(name = "最后登录IP")
	@ApiModelProperty("最后登录IP")
	private String loginIp;
	/** 最后登录时间 */
	@Excel(name = "最后登录时间" , width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("最后登录时间")
	private Date loginDate;
	/** 备注 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;
	/** 医生简介 */
	@Excel(name = "医生简介")
	@ApiModelProperty("医生简介")
	private String introduce;

}
