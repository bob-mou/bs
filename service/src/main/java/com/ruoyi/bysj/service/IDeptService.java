package com.ruoyi.bysj.service;

import com.ruoyi.bysj.domain.Dept;
import com.ruoyi.bysj.vo.DeptVo;
import com.ruoyi.bysj.bo.DeptQueryBo;
import com.ruoyi.bysj.bo.DeptAddBo;
import com.ruoyi.bysj.bo.DeptEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 医院信息管理Service接口
 *
 * @author 牟连波
 * @date 2021-05-01
 */
public interface IDeptService extends IService<Dept> {
	/**
	 * 推荐医院推荐信息
	 * @return
	 */
	List<Dept>  getHList();
	/**
	 * 查询单个医院的部门详细信息
	 * @return
	 */
	List<Dept> deptDetail(Long id);

	/**
	 * 查询单个部门信息
	 * @return
	 */
	DeptVo queryById(Long deptId);

	/**
	 * 查询列表
	 */
	List<DeptVo> queryList(DeptQueryBo bo);

	/**
	 * 根据新增业务对象插入医院信息管理
	 * @param bo 医院信息管理新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(DeptAddBo bo);

	/**
	 * 根据编辑业务对象修改医院信息管理
	 * @param bo 医院信息管理编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(DeptEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
