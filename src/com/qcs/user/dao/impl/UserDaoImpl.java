package com.qcs.user.dao.impl;

import com.qcs.user.dao.UserDao;
import com.qcs.user.mapper.UserMapper;
import com.qcs.user.pojo.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: UserDaoImpl
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */
@Repository
public class UserDaoImpl implements UserDao{
	/**
	*	User映射的mapper
	*/
	@Autowired
	private UserMapper userMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据User的属性。往数据表user_info插入一条新记录
	 * @param user
	 * @return int
	 */
	public int add(User user){

		return userMapper.insertUser(user);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据User的属性,删除数据表user_info一条记录
	 * @param user
	 * @return int
	 */
	public int delete(User user){

		return userMapper.deleteUser(user);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据User的主键,更新数据表user_info一条记录
	 * @param user
	 * @return int
	 */
	public int update(User user){

		return userMapper.updateUser(user);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数user的属性做条件,查询数据表user_info的记录。
	 * @param user
	 * @return List<User>
	 */
	public List<User> query(User user){

		return userMapper.nestedSelectUser(user);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param user
	 * @param pageInfo
	 * @return PaginationResult<User>
	 */
	public PaginationResult<User> query(User user,PaginationInfo pageInfo){

		PaginationContext.set(pageInfo);
		PaginationResult<User> pageResult = new PaginationResult<User>();
		pageResult.setData(query(user));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getUserMapper
	 * @Description 返回userMapper的值
	 * @return UserMapper
	 */
	public UserMapper getUserMapper(){

		return this.userMapper;

	}
	/**
	 *
	 * @Title setUserMapper
	 * @Description 设置userMapper的值
	 * @param userMapper
	 * @return void
	 */
	public void setUserMapper(UserMapper userMapper){

		this.userMapper = userMapper;

	}
}