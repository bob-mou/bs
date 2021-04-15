package com.ruoyi.bysj.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 收藏管理添加对象 collect
 *
 * @author 牟连波
 * @date 2021-04-11
 */
@Data
@ApiModel("收藏管理添加对象")
public class CollectAddBo {

    /** 患者用户id号 */
    @ApiModelProperty("患者用户id号")
    private Long patientId;

    /** 医生ID号 */
    @ApiModelProperty("医生ID号")
    private Long doctorId;

    /** 状态 */
    @ApiModelProperty("状态")
    private String status;

    /** 备注 */
    @ApiModelProperty("备注")
    private String remark;
}
