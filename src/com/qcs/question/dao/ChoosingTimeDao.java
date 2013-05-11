package com.qcs.question.dao;

import com.qcs.question.pojo.ChoosingTime;
import java.util.List;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: ChoosingTimeDao
 * @author 
 * @date 2013-05-11 12:05:09
 *
 */

public interface ChoosingTimeDao{

	/**
	 *
	 * @Title add
	 * @Description 根据ChoosingTime的属性。往数据表choosing_time插入一条新记录
	 * @param choosingTime
	 * @return int
	 */
	public int add(ChoosingTime choosingTime);

	/**
	 *
	 * @Title delete
	 * @Description 根据ChoosingTime的属性,删除数据表choosing_time一条记录
	 * @param choosingTime
	 * @return int
	 */
	public int delete(ChoosingTime choosingTime);

	/**
	 *
	 * @Title update
	 * @Description 根据ChoosingTime的主键,更新数据表choosing_time一条记录
	 * @param choosingTime
	 * @return int
	 */
	public int update(ChoosingTime choosingTime);

	/**
	 *
	 * @Title query
	 * @Description 根据参数choosingTime的属性做条件,查询数据表choosing_time的记录。
	 * @param choosingTime
	 * @return List<ChoosingTime>
	 */
	public List<ChoosingTime> query(ChoosingTime choosingTime);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param choosingTime
	 * @param pageInfo
	 * @return PaginationResult<ChoosingTime>
	 */
	public PaginationResult<ChoosingTime> query(ChoosingTime choosingTime,PaginationInfo pageInfo);

}