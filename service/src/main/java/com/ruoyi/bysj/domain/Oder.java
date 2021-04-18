package com.ruoyi.bysj.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;

/**
 * 订单信息对象 oder
 *
 * @author 牟连波
 * @date 2021-04-16
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("oder")
public class Oder implements Serializable {

private static final long serialVersionUID=1L;


    /** 用户ID号 */
    @TableId(value = "user_ID")
    private Long userId;

    /** 医生id号 */
    private Long doctorId;

    /** 预约日期 */
    private Date yuyueTime;

    /** 上午下午 */
    private Integer isam;

    /** 支付价格 */
    private Integer payMuch;

    /** 支付日期 */
    private Date payTime;

    /** 支付方式 */
    private Integer payWay;

    /** 是否到诊 */
    private Integer iscome;

    /** 评分分数 */
    private Integer star;

    /** 对医生评价 */
    private String messageHospital;

    /** 对系统评价 */
    private String messageSys;

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date creatDate;

    /** 订单状态 */
    private Integer status;

    /** 备注 */
    private String remark;

}
