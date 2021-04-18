package com.ruoyi.bysj.bo;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 放号管理分页查询对象 ticket
 *
 * @author 牟连波
 * @date 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("放号管理分页查询对象")
public class TicketQueryBo extends BaseEntity {

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


	/** 医生id号 */
	@ApiModelProperty("医生id号")
	private Long doctorId;

	/** 医生姓名 */
	@TableField(exist = false)
	private String doctorName;

	/** 预约日期 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty("预约日期")
	private Date yuyueTime;
	/** 上午下午 */
	@ApiModelProperty("上午下午")
	private Integer isam;
	/** 状态 */
	@ApiModelProperty("状态")
	private Integer status;

}
