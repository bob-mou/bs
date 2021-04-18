package com.ruoyi.bysj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.bysj.bo.RelationAddBo;
import com.ruoyi.bysj.bo.RelationQueryBo;
import com.ruoyi.bysj.bo.RelationEditBo;
import com.ruoyi.bysj.domain.Relation;
import com.ruoyi.bysj.mapper.RelationMapper;
import com.ruoyi.bysj.vo.RelationVo;
import com.ruoyi.bysj.service.IRelationService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 家庭成员管理Service业务层处理
 *
 * @author 牟连波
 * @date 2021-04-17
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {

    @Autowired
    private  RelationMapper relationMapper;

    @Override
    public Relation selectRelation(Relation relation) {
        return relationMapper.selectRelation(relation);
    }

    @Override
    public RelationVo queryById(Long userId){
        Relation db = this.baseMapper.selectById(userId);
        return BeanUtil.toBean(db, RelationVo.class);
    }

    @Override
    public List<RelationVo> queryList(RelationQueryBo bo) {
        LambdaQueryWrapper<Relation> lqw = Wrappers.lambdaQuery();
        lqw.like(bo.getUserId() != null, Relation::getUserId, bo.getUserId());
        lqw.like(bo.getFamalyId() != null, Relation::getFamalyId, bo.getFamalyId());
        lqw.eq(StrUtil.isNotBlank(bo.getStatus()), Relation::getStatus, bo.getStatus());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<RelationVo> entity2Vo(Collection<Relation> collection) {
        List<RelationVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, RelationVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<Relation> page = (Page<Relation>)collection;
            Page<RelationVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(RelationAddBo bo) {
        Relation add = BeanUtil.toBean(bo, Relation.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(RelationEditBo bo) {
        Relation update = BeanUtil.toBean(bo, Relation.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(Relation entity){
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
