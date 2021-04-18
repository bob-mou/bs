package com.ruoyi.bysj.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 放号管理编辑对象 ticket
 *
 * @author 牟连波
 * @date 2021-04-18
 */
@Data
@ApiModel("放号管理编辑对象")
public class TicketEditBo {


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

    /** 放号数量 */
    @ApiModelProperty("放号数量")
    private Long numberAll;

    /** 剩余数量 */
    @ApiModelProperty("剩余数量")
    private Long numberLast;

    /** 状态 */
    @ApiModelProperty("状态")
    private Integer status;

    /** 备注 */
    @ApiModelProperty("备注")
    private String remark;
}
