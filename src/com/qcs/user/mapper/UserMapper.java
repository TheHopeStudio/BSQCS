package com.qcs.user.mapper;

import com.qcs.user.pojo.User;
import java.util.List;

/**
 *
 * @ClassName: UserMapper
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface UserMapper{

	/**
	 *
	 * @Title insertUser
	 * @Description 向数据表user_info中插入一条User记录
	 * @param user
	 * @return int
	 */
	public int insertUser(User user);

	/**
	 *
	 * @Title deleteUser
	 * @Description 从数据表user_info中,根据传入参数做条件,删除一条User记录
	 * @param user
	 * @return int
	 */
	public int deleteUser(User user);

	/**
	 *
	 * @Title updateUser
	 * @Description 从数据表user_info中,根据Id,更新一条User记录
	 * @param user
	 * @return int
	 */
	public int updateUser(User user);

	/**
	 *
	 * @Title nestedSelectUser
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param user
	 * @return List<User>
	 */
	public List<User> nestedSelectUser(User user);

}