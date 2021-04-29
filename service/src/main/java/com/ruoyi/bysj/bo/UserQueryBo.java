package com.ruoyi.bysj.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者管理分页查询对象 sys_user
 *
 * @author 牟连波
 * @date 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("患者管理分页查询对象")
public class UserQueryBo extends BaseEntity {

	/** 分页大小 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/** 当前页数 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/** 排序列 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/** 排序的方向desc或者asc */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


	/** 登录账号名称 */
	@ApiModelProperty("登录账号名称")
	private String userName;
	/** 用户姓名 */
	@ApiModelProperty("用户姓名")
	private String nickName;
	/** 用户类型（00系统用户） */
	@ApiModelProperty("用户类型（00系统用户）")
	private String userType;
	/** 手机号码 */
	@ApiModelProperty("手机号码")
	private String phonenumber;
	/** 用户性别（0男 1女 2未知） */
	@ApiModelProperty("用户性别（0男 1女 2未知）")
	private String sex;
	/** 帐号状态（0正常 1停用） */
	@ApiModelProperty("帐号状态（0正常 1停用）")
	private String status;

}
