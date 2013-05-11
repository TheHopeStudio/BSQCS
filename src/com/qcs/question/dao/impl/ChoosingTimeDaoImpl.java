package com.qcs.question.dao.impl;

import com.qcs.question.dao.ChoosingTimeDao;
import com.qcs.question.mapper.ChoosingTimeMapper;
import com.qcs.question.pojo.ChoosingTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: ChoosingTimeDaoImpl
 * @author 
 * @date 2013-05-11 12:05:09
 *
 */
@Repository
public class ChoosingTimeDaoImpl implements ChoosingTimeDao{
	/**
	*	ChoosingTime映射的mapper
	*/
	@Autowired
	private ChoosingTimeMapper choosingTimeMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据ChoosingTime的属性。往数据表choosing_time插入一条新记录
	 * @param choosingTime
	 * @return int
	 */
	public int add(ChoosingTime choosingTime){

		return choosingTimeMapper.insertChoosingTime(choosingTime);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据ChoosingTime的属性,删除数据表choosing_time一条记录
	 * @param choosingTime
	 * @return int
	 */
	public int delete(ChoosingTime choosingTime){

		return choosingTimeMapper.deleteChoosingTime(choosingTime);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据ChoosingTime的主键,更新数据表choosing_time一条记录
	 * @param choosingTime
	 * @return int
	 */
	public int update(ChoosingTime choosingTime){

		return choosingTimeMapper.updateChoosingTime(choosingTime);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数choosingTime的属性做条件,查询数据表choosing_time的记录。
	 * @param choosingTime
	 * @return List<ChoosingTime>
	 */
	public List<ChoosingTime> query(ChoosingTime choosingTime){

		return choosingTimeMapper.nestedSelectChoosingTime(choosingTime);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param choosingTime
	 * @param pageInfo
	 * @return PaginationResult<ChoosingTime>
	 */
	public PaginationResult<ChoosingTime> query(ChoosingTime choosingTime,PaginationInfo pageInfo){

		PaginationContext.set(pageInfo);
		PaginationResult<ChoosingTime> pageResult = new PaginationResult<ChoosingTime>();
		pageResult.setData(query(choosingTime));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getChoosingTimeMapper
	 * @Description 返回choosingTimeMapper的值
	 * @return ChoosingTimeMapper
	 */
	public ChoosingTimeMapper getChoosingTimeMapper(){

		return this.choosingTimeMapper;

	}
	/**
	 *
	 * @Title setChoosingTimeMapper
	 * @Description 设置choosingTimeMapper的值
	 * @param choosingTimeMapper
	 * @return void
	 */
	public void setChoosingTimeMapper(ChoosingTimeMapper choosingTimeMapper){

		this.choosingTimeMapper = choosingTimeMapper;

	}
}