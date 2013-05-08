package com.qcs.menu.dao;

import com.qcs.menu.pojo.Menu;
import java.util.List;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: MenuDao
 * @author 
 * @date 2013-05-05 09:27:18
 *
 */

public interface MenuDao{

	/**
	 *
	 * @Title add
	 * @Description 根据Menu的属性。往数据表menu插入一条新记录
	 * @param menu
	 * @return int
	 */
	public int add(Menu menu);

	/**
	 *
	 * @Title delete
	 * @Description 根据Menu的属性,删除数据表menu一条记录
	 * @param menu
	 * @return int
	 */
	public int delete(Menu menu);

	/**
	 *
	 * @Title update
	 * @Description 根据Menu的主键,更新数据表menu一条记录
	 * @param menu
	 * @return int
	 */
	public int update(Menu menu);

	/**
	 *
	 * @Title query
	 * @Description 根据参数menu的属性做条件,查询数据表menu的记录。
	 * 若join为true则采用表连接查询复杂属性.否则采用子查询方式查询
	 * @param menu
	 * @param join
	 * @return List<Menu>
	 */
	public List<Menu> query(Menu menu,boolean join);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param menu
	 * @param pageInfo
	 * @param join
	 * @return PaginationResult<Menu>
	 */
	public PaginationResult<Menu> query(Menu menu,PaginationInfo pageInfo,boolean join);

	/**
	 *
	 * @Title query
	 * @Description 根据参数menu的属性做条件,查询数据表menu的记录。采用嵌套查询方式查询复杂属性
	 * @param menu
	 * @return List<Menu>
	 */
	public List<Menu> query(Menu menu);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param menu
	 * @param pageInfo
	 * @return PaginationResult<Menu>
	 */
	public PaginationResult<Menu> query(Menu menu,PaginationInfo pageInfo);

}