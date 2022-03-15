package com.ruoyi.bysj.vo;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 医院信息管理视图对象 mall_package
 *
 * @author 牟连波
 * @date 2021-05-01
 */
@Data
@ApiModel("医院信息管理视图对象")
public class DeptVo {
	private static final long serialVersionUID = 1L;

	/** 部门id */
	@ApiModelProperty("部门id")
	private Long deptId;

	/** 父部门id */
	@Excel(name = "父部门id")
	@ApiModelProperty("父部门id")
	private Long parentId;
	/** 部门名称 */
	@Excel(name = "部门名称")
	@ApiModelProperty("部门名称")
	private String deptName;
	/** 负责人 */
	@Excel(name = "负责人")
	@ApiModelProperty("负责人")
	private String leader;
	/** 联系电话 */
	@Excel(name = "联系电话")
	@ApiModelProperty("联系电话")
	private String phone;
	/** 邮箱 */
	@Excel(name = "邮箱")
	@ApiModelProperty("邮箱")
	private String email;
	/** 部门状态（0正常 1停用） */
	@Excel(name = "部门状态" , readConverterExp = "0=正常,1=停用")
	@ApiModelProperty("部门状态（0正常 1停用）")
	private String status;
	/** 详细介绍 */
	@Excel(name = "详细介绍")
	@ApiModelProperty("详细介绍")
	private String introduce;
	/** 位置 */
	@Excel(name = "位置")
	@ApiModelProperty("位置")
	private String position;
	/** 头像地址 */
	@Excel(name = "头像地址")
	@ApiModelProperty("头像地址")
	private String picUrl;
	/** 医院等级 */
	@Excel(name = "医院等级")
	@ApiModelProperty("医院等级")
	private String rank;
	/** 综合评分 */
	@Excel(name = "综合评分")
	@ApiModelProperty("综合评分")
	private Integer star;
}
