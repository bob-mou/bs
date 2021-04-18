package com.ruoyi.bysj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.bysj.bo.OderAddBo;
import com.ruoyi.bysj.bo.OderQueryBo;
import com.ruoyi.bysj.bo.OderEditBo;
import com.ruoyi.bysj.domain.Oder;
import com.ruoyi.bysj.mapper.OderMapper;
import com.ruoyi.bysj.vo.OderVo;
import com.ruoyi.bysj.service.IOderService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单信息Service业务层处理
 *
 * @author 牟连波
 * @date 2021-04-16
 */
@Service
public class OderServiceImpl extends ServiceImpl<OderMapper, Oder> implements IOderService {

    @Override
    public OderVo queryById(Long userId){
        Oder db = this.baseMapper.selectById(userId);
        return BeanUtil.toBean(db, OderVo.class);
    }

    @Override
    public List<OderVo> queryList(OderQueryBo bo) {
        LambdaQueryWrapper<Oder> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, Oder::getUserId, bo.getUserId());
        lqw.eq(bo.getDoctorId() != null, Oder::getDoctorId, bo.getDoctorId());
        lqw.eq(bo.getYuyueTime() != null, Oder::getYuyueTime, bo.getYuyueTime());
        lqw.eq(bo.getIsam() != null, Oder::getIsam, bo.getIsam());
        lqw.eq(bo.getPayWay() != null, Oder::getPayWay, bo.getPayWay());
        lqw.eq(bo.getIscome() != null, Oder::getIscome, bo.getIscome());
        lqw.eq(bo.getStatus() != null, Oder::getStatus, bo.getStatus());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<OderVo> entity2Vo(Collection<Oder> collection) {
        List<OderVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, OderVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<Oder> page = (Page<Oder>)collection;
            Page<OderVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(OderAddBo bo) {
        Oder add = BeanUtil.toBean(bo, Oder.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(OderEditBo bo) {
        Oder update = BeanUtil.toBean(bo, Oder.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(Oder entity){
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
