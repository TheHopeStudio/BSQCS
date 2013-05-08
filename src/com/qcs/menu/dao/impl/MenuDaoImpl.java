package com.qcs.menu.dao.impl;

import com.qcs.menu.dao.MenuDao;
import com.qcs.menu.mapper.MenuMapper;
import com.qcs.menu.pojo.Menu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: MenuDaoImpl
 * @author 
 * @date 2013-05-05 09:27:18
 *
 */
public class MenuDaoImpl implements MenuDao{
	/**
	*	Menu映射的mapper
	*/
	private MenuMapper menuMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据Menu的属性。往数据表menu插入一条新记录
	 * @param menu
	 * @return int
	 */
	public int add(Menu menu){

		return menuMapper.insertMenu(menu);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据Menu的属性,删除数据表menu一条记录
	 * @param menu
	 * @return int
	 */
	public int delete(Menu menu){

		return menuMapper.deleteMenu(menu);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据Menu的主键,更新数据表menu一条记录
	 * @param menu
	 * @return int
	 */
	public int update(Menu menu){

		return menuMapper.updateMenu(menu);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数menu的属性做条件,查询数据表menu的记录。
	 * 若join为true则采用表连接查询复杂属性.否则采用子查询方式查询
	 * @param menu
	 * @param join
	 * @return List<Menu>
	 */
	public List<Menu> query(Menu menu,boolean join){

		if(join){
			return menuMapper.joinSelectMenu(menu);
		}else{
			return menuMapper.nestedSelectMenu(menu);
		}

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param menu
	 * @param pageInfo
	 * @param join
	 * @return PaginationResult<Menu>
	 */
	public PaginationResult<Menu> query(Menu menu,PaginationInfo pageInfo,boolean join){

		PaginationContext.set(pageInfo);
		PaginationResult<Menu> pageResult = new PaginationResult<Menu>();
		pageResult.setData(query(menu,join));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数menu的属性做条件,查询数据表menu的记录。采用嵌套查询方式查询复杂属性
	 * @param menu
	 * @return List<Menu>
	 */
	public List<Menu> query(Menu menu){

		return query(menu,false);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param menu
	 * @param pageInfo
	 * @return PaginationResult<Menu>
	 */
	public PaginationResult<Menu> query(Menu menu,PaginationInfo pageInfo){

		PaginationContext.set(pageInfo);
		PaginationResult<Menu> pageResult = new PaginationResult<Menu>();
		pageResult.setData(query(menu));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getMenuMapper
	 * @Description 返回menuMapper的值
	 * @return MenuMapper
	 */
	public MenuMapper getMenuMapper(){

		return this.menuMapper;

	}
	/**
	 *
	 * @Title setMenuMapper
	 * @Description 设置menuMapper的值
	 * @param menuMapper
	 * @return void
	 */
	public void setMenuMapper(MenuMapper menuMapper){

		this.menuMapper = menuMapper;

	}
}