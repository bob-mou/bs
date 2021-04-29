package com.ruoyi.bysj.mapper;

import com.ruoyi.bysj.domain.Relation;
import com.ruoyi.bysj.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 患者管理Mapper接口
 *
 * @author 牟连波
 * @date 2021-04-20
 */
public interface UserMapper extends BaseMapper<User> {
    public User selectUser(String phonenumber);
}
