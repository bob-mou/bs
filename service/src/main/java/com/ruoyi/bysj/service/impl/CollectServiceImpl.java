package com.ruoyi.bysj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.bysj.bo.CollectAddBo;
import com.ruoyi.bysj.bo.CollectQueryBo;
import com.ruoyi.bysj.bo.CollectEditBo;
import com.ruoyi.bysj.domain.Collect;
import com.ruoyi.bysj.mapper.CollectMapper;
import com.ruoyi.bysj.vo.CollectVo;
import com.ruoyi.bysj.service.ICollectService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 收藏管理Service业务层处理
 *
 * @author 牟连波
 * @date 2021-04-11
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public CollectVo queryById(Long patientId){
        Collect db = this.baseMapper.selectById(patientId);
        return BeanUtil.toBean(db, CollectVo.class);
    }

    @Override
    public List<CollectVo> queryList(CollectQueryBo bo) {
        LambdaQueryWrapper<Collect> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getDoctorId() != null, Collect::getDoctorId, bo.getDoctorId());
        lqw.eq(StrUtil.isNotBlank(bo.getStatus()), Collect::getStatus, bo.getStatus());
        return entity2Vo(this.list(lqw));
    }

    @Override
    public List<Collect> selectCollectList(Collect bo) {
        return collectMapper.selectCollectList(bo);
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<CollectVo> entity2Vo(Collection<Collect> collection) {
        List<CollectVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, CollectVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<Collect> page = (Page<Collect>)collection;
            Page<CollectVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(CollectAddBo bo) {
        Collect add = BeanUtil.toBean(bo, Collect.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(CollectEditBo bo) {
        Collect update = BeanUtil.toBean(bo, Collect.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(Collect entity){
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
