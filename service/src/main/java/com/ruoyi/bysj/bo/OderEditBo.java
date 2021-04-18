package com.ruoyi.bysj.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单信息编辑对象 oder
 *
 * @author 牟连波
 * @date 2021-04-16
 */
@Data
@ApiModel("订单信息编辑对象")
public class OderEditBo {


    /** 用户ID号 */
    @ApiModelProperty("用户ID号")
    private Long userId;

    /** 医生id号 */
    @ApiModelProperty("医生id号")
    private Long doctorId;

    /** 预约日期 */
    @ApiModelProperty("预约日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yuyueTime;

    /** 上午下午 */
    @ApiModelProperty("上午下午")
    private Integer isam;

    /** 支付价格 */
    @ApiModelProperty("支付价格")
    private Integer payMuch;

    /** 支付日期 */
    @ApiModelProperty("支付日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    /** 支付方式 */
    @ApiModelProperty("支付方式")
    private Integer payWay;

    /** 是否到诊 */
    @ApiModelProperty("是否到诊")
    private Integer iscome;

    /** 评分分数 */
    @ApiModelProperty("评分分数")
    private Integer star;

    /** 对医生评价 */
    @ApiModelProperty("对医生评价")
    private String messageHospital;

    /** 对系统评价 */
    @ApiModelProperty("对系统评价")
    private String messageSys;

    /** 订单状态 */
    @ApiModelProperty("订单状态")
    private Integer status;

    /** 备注 */
    @ApiModelProperty("备注")
    private String remark;
}
