package com.ruoyi.bysj.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * 收藏管理对象 collect
 *
 * @author 牟连波
 * @date 2021-04-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("collect")
public class Collect implements Serializable {

private static final long serialVersionUID=1L;


    /** 患者用户id号 */
    @TableId(value = "patient_ID")
    private Long patientId;

    /** 医生ID号 */
    private Long doctorId;

    /** 创建时间 */
    private Date creatTime;

    /** 状态 */
    private String status;

    /** 备注 */
    private String remark;

    /** 医生姓名 */
    private String doctorName;

    /** 患者用户姓名 */
    private String patientName;

}
