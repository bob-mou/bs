package com.ruoyi.bysj.service;

import com.ruoyi.bysj.domain.User;
import com.ruoyi.bysj.vo.UserVo;
import com.ruoyi.bysj.bo.UserQueryBo;
import com.ruoyi.bysj.bo.UserAddBo;
import com.ruoyi.bysj.bo.UserEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 患者管理Service接口
 *
 * @author 牟连波
 * @date 2021-04-20
 */
public interface IUserService extends IService<User> {

	/**
	 * 查询同一个部门医生的信息
	 * @return
	 */
	List<User>  docListInA(Long deptId);

	/**
	 * 查询单个
	 * @return
	 */

	User selectUser(String phonenumber);
	/**
	 * 获取医生推荐列表
	 * @return
	 */
	List<User> getDoList();
	/**
	 * 查询单个
	 * @return
	 */
	UserVo queryById(Long userId);

	/**
	 * 查询列表
	 */
	List<UserVo> queryList(UserQueryBo bo);

	/**
	 * 根据新增业务对象插入患者管理
	 * @param bo 患者管理新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(UserAddBo bo);

	/**
	 * 根据编辑业务对象修改患者管理
	 * @param bo 患者管理编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(UserEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
