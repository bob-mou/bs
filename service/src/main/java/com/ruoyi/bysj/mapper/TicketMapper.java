package com.ruoyi.bysj.mapper;

import com.ruoyi.bysj.domain.Collect;
import com.ruoyi.bysj.domain.Ticket;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 放号管理Mapper接口
 *
 * @author 牟连波
 * @date 2021-04-18
 */
public interface TicketMapper extends BaseMapper<Ticket> {
    public List<Ticket> selectTicketList(Ticket bo);

    public List<Ticket> queryDocId(Long id);

}
