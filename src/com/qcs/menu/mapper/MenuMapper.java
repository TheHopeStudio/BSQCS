package com.qcs.menu.mapper;

import com.qcs.menu.pojo.Menu;
import java.util.List;

/**
 *
 * @ClassName: MenuMapper
 * @author 
 * @date 2013-05-05 09:27:18
 *
 */

public interface MenuMapper{

	/**
	 *
	 * @Title insertMenu
	 * @Description 向数据表menu中插入一条Menu记录
	 * @param menu
	 * @return int
	 */
	public int insertMenu(Menu menu);

	/**
	 *
	 * @Title deleteMenu
	 * @Description 从数据表menu中,根据传入参数做条件,删除一条Menu记录
	 * @param menu
	 * @return int
	 */
	public int deleteMenu(Menu menu);

	/**
	 *
	 * @Title updateMenu
	 * @Description 从数据表menu中,根据Id,更新一条Menu记录
	 * @param menu
	 * @return int
	 */
	public int updateMenu(Menu menu);

	/**
	 *
	 * @Title nestedSelectMenu
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param menu
	 * @return List<Menu>
	 */
	public List<Menu> nestedSelectMenu(Menu menu);

	/**
	 *
	 * @Title joinSelectMenu
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,采用连表查询的方式
	 * @param menu
	 * @return List<Menu>
	 */
	public List<Menu> joinSelectMenu(Menu menu);

}