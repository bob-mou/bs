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
 * 放号管理视图对象 mall_package
 *
 * @author 牟连波
 * @date 2021-04-18
 */
@Data
@ApiModel("放号管理视图对象")
public class TicketVo {
	private static final long serialVersionUID = 1L;

	/** 医生id号 */
	@Excel(name = "医生id号")
	@ApiModelProperty("医生id号")
	private Long doctorId;
	/** 预约日期 */
	@Excel(name = "预约日期" , width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty("预约日期")
	private Date yuyueTime;
	/** 上午下午 */
	@Excel(name = "上午下午")
	@ApiModelProperty("上午下午")
	private Integer isam;
	/** 放号数量 */
	@Excel(name = "放号数量")
	@ApiModelProperty("放号数量")
	private Long numberAll;
	/** 剩余数量 */
	@Excel(name = "剩余数量")
	@ApiModelProperty("剩余数量")
	private Long numberLast;
	/** 创建时间 */
	@Excel(name = "创建时间" , width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date createTime;
	/** 状态 */
	@Excel(name = "状态")
	@ApiModelProperty("状态")
	private Integer status;
	/** 备注 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;

}
