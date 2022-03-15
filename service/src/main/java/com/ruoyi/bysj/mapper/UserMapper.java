package com.ruoyi.bysj.mapper;

import com.ruoyi.bysj.domain.Relation;
import com.ruoyi.bysj.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 患者管理Mapper接口
 *
 * @author 牟连波
 * @date 2021-04-20
 */
public interface UserMapper extends BaseMapper<User> {

    public User selectUser(String phonenumber);
    //获取医生推荐信息
    public List<User> getDoList();

    public List<User>  docListInA(Long deptId);

}
