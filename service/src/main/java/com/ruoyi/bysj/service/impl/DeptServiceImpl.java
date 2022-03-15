package com.ruoyi.bysj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.bysj.bo.DeptAddBo;
import com.ruoyi.bysj.bo.DeptQueryBo;
import com.ruoyi.bysj.bo.DeptEditBo;
import com.ruoyi.bysj.domain.Dept;
import com.ruoyi.bysj.mapper.DeptMapper;
import com.ruoyi.bysj.vo.DeptVo;
import com.ruoyi.bysj.service.IDeptService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 医院信息管理Service业务层处理
 *
 * @author 牟连波
 * @date 2021-05-01
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;



    @Override
    public List<Dept> getHList() {
        return deptMapper.getHList();
    }

    @Override
    public List<Dept> deptDetail(Long id) {
        List<Dept> deptList = this.baseMapper.deptDetail(id);
        return deptList;
    }

    @Override
    public DeptVo queryById(Long deptId){
        Dept db = this.baseMapper.selectById(deptId);
        return BeanUtil.toBean(db, DeptVo.class);
    }

    @Override
    public List<DeptVo> queryList(DeptQueryBo bo) {
        LambdaQueryWrapper<Dept> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getDeptName()), Dept::getDeptName, bo.getDeptName());
        lqw.like(StrUtil.isNotBlank(bo.getLeader()), Dept::getLeader, bo.getLeader());
        lqw.eq(StrUtil.isNotBlank(bo.getPhone()), Dept::getPhone, bo.getPhone());
        lqw.eq(StrUtil.isNotBlank(bo.getStatus()), Dept::getStatus, bo.getStatus());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<DeptVo> entity2Vo(Collection<Dept> collection) {
        List<DeptVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, DeptVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<Dept> page = (Page<Dept>)collection;
            Page<DeptVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(DeptAddBo bo) {
        Dept add = BeanUtil.toBean(bo, Dept.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(DeptEditBo bo) {
        Dept update = BeanUtil.toBean(bo, Dept.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(Dept entity){
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
