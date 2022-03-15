package com.ruoyi.bysj.service;

import com.ruoyi.bysj.domain.Ticket;
import com.ruoyi.bysj.vo.TicketVo;
import com.ruoyi.bysj.bo.TicketQueryBo;
import com.ruoyi.bysj.bo.TicketAddBo;
import com.ruoyi.bysj.bo.TicketEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 放号管理Service接口
 *
 * @author 牟连波
 * @date 2021-04-18
 */
public interface ITicketService extends IService<Ticket> {

	/**
	 * 查询一个医生放号信息
	 */
	public List<Ticket> queryDocId(Long id);

	/**
	 * 查询列表
	 */
	public List<Ticket> selectTicketList(Ticket bo);
	/**
	 * 查询单个
	 * @return
	 */
	TicketVo queryById(Long doctorId);

	/**
	 * 查询列表
	 */
	List<TicketVo> queryList(TicketQueryBo bo);

	/**
	 * 根据新增业务对象插入放号管理
	 * @param bo 放号管理新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TicketAddBo bo);

	/**
	 * 根据编辑业务对象修改放号管理
	 * @param bo 放号管理编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TicketEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
