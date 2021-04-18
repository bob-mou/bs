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
 * 订单信息视图对象 mall_package
 *
 * @author 牟连波
 * @date 2021-04-16
 */
@Data
@ApiModel("订单信息视图对象")
public class OderVo {
	private static final long serialVersionUID = 1L;

	/** 用户ID号 */
	@Excel(name = "用户ID号")
	@ApiModelProperty("用户ID号")
	private Long userId;
	/** 医生id号 */
	@Excel(name = "医生id号")
	@ApiModelProperty("医生id号")
	private Long doctorId;
	/** 预约日期 */
	@Excel(name = "预约日期" , width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("预约日期")
	private Date yuyueTime;
	/** 上午下午 */
	@Excel(name = "上午下午")
	@ApiModelProperty("上午下午")
	private Integer isam;
	/** 支付价格 */
	@Excel(name = "支付价格")
	@ApiModelProperty("支付价格")
	private Integer payMuch;
	/** 支付日期 */
	@Excel(name = "支付日期" , width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("支付日期")
	private Date payTime;
	/** 支付方式 */
	@Excel(name = "支付方式")
	@ApiModelProperty("支付方式")
	private Integer payWay;
	/** 是否到诊 */
	@Excel(name = "是否到诊")
	@ApiModelProperty("是否到诊")
	private Integer iscome;
	/** 评分分数 */
	@Excel(name = "评分分数")
	@ApiModelProperty("评分分数")
	private Integer star;
	/** 对医生评价 */
	@Excel(name = "对医生评价")
	@ApiModelProperty("对医生评价")
	private String messageHospital;
	/** 对系统评价 */
	@Excel(name = "对系统评价")
	@ApiModelProperty("对系统评价")
	private String messageSys;
	/** 创建时间 */
	@Excel(name = "创建时间" , width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date creatDate;
	/** 订单状态 */
	@Excel(name = "订单状态")
	@ApiModelProperty("订单状态")
	private Integer status;
	/** 备注 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;

}
