package com.ruoyi.bysj.mapper;

import com.ruoyi.bysj.bo.CollectQueryBo;
import com.ruoyi.bysj.domain.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.bysj.vo.CollectVo;

import java.util.List;

/**
 * 收藏管理Mapper接口
 *
 * @author 牟连波
 * @date 2021-04-11
 */
public interface CollectMapper extends BaseMapper<Collect> {

    public List<Collect> selectCollectList(Collect bo);
}
