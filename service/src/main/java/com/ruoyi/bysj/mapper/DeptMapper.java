package com.ruoyi.bysj.mapper;

import com.ruoyi.bysj.domain.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 医院信息管理Mapper接口
 *
 * @author 牟连波
 * @date 2021-05-01
 */
public interface DeptMapper extends BaseMapper<Dept> {
    //获取医院推荐信息
    public List<Dept> getHList();

    //获取一个医院下部门列表列表
    public List<Dept> deptDetail(Long id);

}
