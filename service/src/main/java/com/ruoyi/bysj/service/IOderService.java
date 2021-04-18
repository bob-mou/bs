package com.ruoyi.bysj.service;

import com.ruoyi.bysj.domain.Oder;
import com.ruoyi.bysj.vo.OderVo;
import com.ruoyi.bysj.bo.OderQueryBo;
import com.ruoyi.bysj.bo.OderAddBo;
import com.ruoyi.bysj.bo.OderEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 订单信息Service接口
 *
 * @author 牟连波
 * @date 2021-04-16
 */
public interface IOderService extends IService<Oder> {
	/**
	 * 查询单个
	 * @return
	 */
	OderVo queryById(Long userId);

	/**
	 * 查询列表
	 */
	List<OderVo> queryList(OderQueryBo bo);

	/**
	 * 根据新增业务对象插入订单信息
	 * @param bo 订单信息新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(OderAddBo bo);

	/**
	 * 根据编辑业务对象修改订单信息
	 * @param bo 订单信息编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(OderEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

}
