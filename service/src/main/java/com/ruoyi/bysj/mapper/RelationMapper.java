package com.ruoyi.bysj.mapper;

import com.ruoyi.bysj.domain.Collect;
import com.ruoyi.bysj.domain.Relation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.bysj.domain.Ticket;

import java.util.List;

/**
 * 家庭成员管理Mapper接口
 *
 * @author 牟连波
 * @date 2021-04-17
 */
public interface RelationMapper extends BaseMapper<Relation> {
    public Relation selectRelation(Relation relation);

    public List<Relation> queryList(Relation bo);
}
