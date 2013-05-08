package com.qcs.user.dao;

import com.qcs.user.pojo.User;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: UserDao
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface UserDao{

	/**
	 *
	 * @Title add
	 * @Description 根据User的属性。往数据表user_info插入一条新记录
	 * @param user
	 * @return int
	 */
	public int add(User user) throws DataAccessException;

	/**
	 *
	 * @Title delete
	 * @Description 根据User的属性,删除数据表user_info一条记录
	 * @param user
	 * @return int
	 */
	public int delete(User user) throws DataAccessException;

	/**
	 *
	 * @Title update
	 * @Description 根据User的主键,更新数据表user_info一条记录
	 * @param user
	 * @return int
	 */
	public int update(User user) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 根据参数user的属性做条件,查询数据表user_info的记录。
	 * @param user
	 * @return List<User>
	 */
	public List<User> query(User user) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param user
	 * @param pageInfo
	 * @return PaginationResult<User>
	 */
	public PaginationResult<User> query(User user,PaginationInfo pageInfo) throws DataAccessException;

}