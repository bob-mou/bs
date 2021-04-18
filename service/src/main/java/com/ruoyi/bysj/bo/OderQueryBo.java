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
 * 订单信息分页查询对象 oder
 *
 * @author 牟连波
 * @date 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("订单信息分页查询对象")
public class OderQueryBo extends BaseEntity {

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


	/** 用户ID号 */
	@ApiModelProperty("用户ID号")
	private Long userId;
	/** 医生id号 */
	@ApiModelProperty("医生id号")
	private Long doctorId;
	/** 预约日期 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("预约日期")
	private Date yuyueTime;
	/** 上午下午 */
	@ApiModelProperty("上午下午")
	private Integer isam;
	/** 支付方式 */
	@ApiModelProperty("支付方式")
	private Integer payWay;
	/** 是否到诊 */
	@ApiModelProperty("是否到诊")
	private Integer iscome;
	/** 订单状态 */
	@ApiModelProperty("订单状态")
	private Integer status;

}
