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
 * 收藏管理视图对象 mall_package
 *
 * @author 牟连波
 * @date 2021-04-11
 */
@Data
@ApiModel("收藏管理视图对象")
public class CollectVo {
	private static final long serialVersionUID = 1L;

	/** 患者用户id号 */
	@Excel(name = "患者用户id号")
	@ApiModelProperty("患者用户id号")
	private Long patientId;

	/** 医生ID号 */
	@Excel(name = "医生ID号")
	@ApiModelProperty("医生ID号")
	private Long doctorId;


	/** 患者用户姓名 */
	@Excel(name = "患者用户姓名")
	@ApiModelProperty("患者用户姓名")
	private String doctorName;


	/** 医生姓名 */
	@Excel(name = "医生姓名")
	@ApiModelProperty("医生姓名")
	private String patientName;


	/** 创建时间 */
	@Excel(name = "创建时间" , width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date creatTime;

	/** 状态 */
	@Excel(name = "状态")
	@ApiModelProperty("状态")
	private String status;

	/** 备注 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;

}
