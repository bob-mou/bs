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
 * 家庭成员管理分页查询对象 relation
 *
 * @author 牟连波
 * @date 2021-04-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("家庭成员管理分页查询对象")
public class RelationQueryBo extends BaseEntity {

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

	/** 患者用户姓名 */
	@TableField(exist = false)
	private String userName;

	/** 患者用户家属姓名 */
	@TableField(exist = false)
	private String familyName;

	/** 患者用户ID */
	@ApiModelProperty("患者用户ID")
	private Long userId;
	/** 家庭成员ID */
	@ApiModelProperty("家庭成员ID")
	private Long famalyId;
	/** 状态 */
	@ApiModelProperty("状态")
	private String status;

}
