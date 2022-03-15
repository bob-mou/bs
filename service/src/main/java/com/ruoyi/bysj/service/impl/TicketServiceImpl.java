package com.ruoyi.bysj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.bysj.bo.TicketAddBo;
import com.ruoyi.bysj.bo.TicketQueryBo;
import com.ruoyi.bysj.bo.TicketEditBo;
import com.ruoyi.bysj.domain.Ticket;
import com.ruoyi.bysj.mapper.TicketMapper;
import com.ruoyi.bysj.vo.TicketVo;
import com.ruoyi.bysj.service.ITicketService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 放号管理Service业务层处理
 *
 * @author 牟连波
 * @date 2021-04-18
 */
@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket> implements ITicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<Ticket> queryDocId(Long id){
        return ticketMapper.queryDocId(id);
    };

    @Override
    public List<Ticket> selectTicketList(Ticket bo) {
        return ticketMapper.selectTicketList(bo);
    }

    @Override
    public TicketVo queryById(Long doctorId){
        Ticket db = this.baseMapper.selectById(doctorId);
        return BeanUtil.toBean(db, TicketVo.class);

    }

    @Override
    public List<TicketVo> queryList(TicketQueryBo bo) {
        LambdaQueryWrapper<Ticket> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getDoctorId() != null, Ticket::getDoctorId, bo.getDoctorId());
        lqw.eq(bo.getYuyueTime() != null, Ticket::getYuyueTime, bo.getYuyueTime());
        lqw.eq(bo.getIsam() != null, Ticket::getIsam, bo.getIsam());
        lqw.eq(bo.getStatus() != null, Ticket::getStatus, bo.getStatus());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<TicketVo> entity2Vo(Collection<Ticket> collection) {
        List<TicketVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, TicketVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<Ticket> page = (Page<Ticket>)collection;
            Page<TicketVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(TicketAddBo bo) {
        Ticket add = BeanUtil.toBean(bo, Ticket.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(TicketEditBo bo) {
        Ticket update = BeanUtil.toBean(bo, Ticket.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(Ticket entity){
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
