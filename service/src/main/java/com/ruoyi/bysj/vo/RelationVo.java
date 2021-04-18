package com.ruoyi.bysj.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 家庭成员管理视图对象 mall_package
 *
 * @author 牟连波
 * @date 2021-04-17
 */
@Data
@ApiModel("家庭成员管理视图对象")
public class RelationVo {
	private static final long serialVersionUID = 1L;

	/** 患者用户ID */
	@Excel(name = "患者用户ID")
	@ApiModelProperty("患者用户ID")
	private Long userId;
	/** 家庭成员ID */
	@Excel(name = "家庭成员ID")
	@ApiModelProperty("家庭成员ID")
	private Long famalyId;
	/** 患者用户姓名 */
	@Excel(name = "患者用户姓名")
	@ApiModelProperty("患者用户姓名")
	private String userName;
	/** 患者用户家属姓名 */
	@Excel(name = "患者用户家属姓名")
	@ApiModelProperty("患者用户家属姓名")
	private String familyName;
	/** 家庭关系 */
	@Excel(name = "家庭关系")
	@ApiModelProperty("家庭关系")
	private Integer relation;
	/** 创建时间 */
	@Excel(name = "创建时间" , width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date creatTime;
	/** 状态 */
	@Excel(name = "状态")
	@ApiModelProperty("状态")
	private String status;
	/** 注释 */
	@Excel(name = "注释")
	@ApiModelProperty("注释")
	private String remark;


}
