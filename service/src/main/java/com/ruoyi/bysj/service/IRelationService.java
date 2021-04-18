package com.ruoyi.bysj.service;

import com.ruoyi.bysj.domain.Relation;
import com.ruoyi.bysj.vo.RelationVo;
import com.ruoyi.bysj.bo.RelationQueryBo;
import com.ruoyi.bysj.bo.RelationAddBo;
import com.ruoyi.bysj.bo.RelationEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 家庭成员管理Service接口
 *
 * @author 牟连波
 * @date 2021-04-17
 */
public interface IRelationService extends IService<Relation> {

	/**
	 * 查询单个
	 * @return
	 */
	Relation selectRelation(Relation relation);

	/**
	 * 查询单个
	 * @return
	 */
	RelationVo queryById(Long userId);

	/**
	 * 查询列表
	 */
	List<RelationVo> queryList(RelationQueryBo bo);

	/**
	 * 根据新增业务对象插入家庭成员管理
	 * @param bo 家庭成员管理新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(RelationAddBo bo);

	/**
	 * 根据编辑业务对象修改家庭成员管理
	 * @param bo 家庭成员管理编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(RelationEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
