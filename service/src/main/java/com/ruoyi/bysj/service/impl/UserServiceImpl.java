package com.ruoyi.bysj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.bysj.bo.UserAddBo;
import com.ruoyi.bysj.bo.UserQueryBo;
import com.ruoyi.bysj.bo.UserEditBo;
import com.ruoyi.bysj.domain.User;
import com.ruoyi.bysj.mapper.UserMapper;
import com.ruoyi.bysj.vo.UserVo;
import com.ruoyi.bysj.service.IUserService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 患者管理Service业务层处理
 *
 * @author 牟连波
 * @date 2021-04-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(String phonenumber) {
        return userMapper.selectUser(phonenumber);
    }

    @Override
    public UserVo queryById(Long userId){
        User db = this.baseMapper.selectById(userId);
        return BeanUtil.toBean(db, UserVo.class);
    }



    @Override
    public List<UserVo> queryList(UserQueryBo bo) {
        LambdaQueryWrapper<User> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getUserName()), User::getUserName, bo.getUserName());
        lqw.like(StrUtil.isNotBlank(bo.getNickName()), User::getNickName, bo.getNickName());
        lqw.eq(StrUtil.isNotBlank(bo.getUserType()), User::getUserType, bo.getUserType());
        lqw.eq(StrUtil.isNotBlank(bo.getPhonenumber()), User::getPhonenumber, bo.getPhonenumber());
        lqw.eq(StrUtil.isNotBlank(bo.getSex()), User::getSex, bo.getSex());
        lqw.eq(StrUtil.isNotBlank(bo.getStatus()), User::getStatus, bo.getStatus());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<UserVo> entity2Vo(Collection<User> collection) {
        List<UserVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, UserVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<User> page = (Page<User>)collection;
            Page<UserVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(UserAddBo bo) {
        User add = BeanUtil.toBean(bo, User.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(UserEditBo bo) {
        User update = BeanUtil.toBean(bo, User.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(User entity){
        //TODO 做一些数据校验,如唯一约束
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return this.removeByIds(ids);
    }
}
