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
 * 收藏管理分页查询对象 collect
 *
 * @author 牟连波
 * @date 2021-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("收藏管理分页查询对象")
public class CollectQueryBo extends BaseEntity {

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


	/** 医生ID号 */
	@ApiModelProperty("医生ID号")
	private Long doctorId;
	/** 状态 */
	@ApiModelProperty("状态")
	private String status;

}
