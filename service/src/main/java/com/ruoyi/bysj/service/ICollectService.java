package com.ruoyi.bysj.service;

import com.ruoyi.bysj.domain.Collect;
import com.ruoyi.bysj.vo.CollectVo;
import com.ruoyi.bysj.bo.CollectQueryBo;
import com.ruoyi.bysj.bo.CollectAddBo;
import com.ruoyi.bysj.bo.CollectEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 收藏管理Service接口
 *
 * @author 牟连波
 * @date 2021-04-11
 */
public interface ICollectService extends IService<Collect> {
	/**
	 * 查询单个
	 * @return
	 */
	CollectVo queryById(Long patientId);

	/**
	 * 查询列表
	 */
	List<CollectVo> queryList(CollectQueryBo bo);

	/**
	 * 根据新增业务对象插入收藏管理
	 * @param bo 收藏管理新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(CollectAddBo bo);

	/**
	 * 根据编辑业务对象修改收藏管理
	 * @param bo 收藏管理编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(CollectEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
