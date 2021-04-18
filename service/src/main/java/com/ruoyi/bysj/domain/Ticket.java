package com.ruoyi.bysj.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;

/**
 * 放号管理对象 ticket
 *
 * @author 牟连波
 * @date 2021-04-18
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ticket")
public class Ticket implements Serializable {

private static final long serialVersionUID=1L;


    /** 医生id号 */
    @TableId(value = "doctor_ID")
    private Long doctorId;

    /** 医生姓名 */
    @TableField(exist = false)
    private String doctorName;

    /** 预约日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date yuyueTime;

    /** 上午下午 */
    private Integer isam;

    /** 放号数量 */
    private Long numberAll;

    /** 剩余数量 */
    private Long numberLast;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** 状态 */
    private Integer status;

    /** 备注 */
    private String remark;

}
