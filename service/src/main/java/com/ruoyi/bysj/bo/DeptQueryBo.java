package com.ruoyi.bysj.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医院信息管理分页查询对象 dept
 *
 * @author 牟连波
 * @date 2021-05-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("医院信息管理分页查询对象")
public class DeptQueryBo extends BaseEntity {

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


	/** 部门名称 */
	@ApiModelProperty("部门名称")
	private String deptName;
	/** 负责人 */
	@ApiModelProperty("负责人")
	private String leader;
	/** 联系电话 */
	@ApiModelProperty("联系电话")
	private String phone;
	/** 部门状态（0正常 1停用） */
	@ApiModelProperty("部门状态（0正常 1停用）")
	private String status;

}
