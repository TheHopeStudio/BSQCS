package com.qcs.question.mapper;

import com.qcs.question.pojo.ChoosingTime;
import java.util.List;

/**
 *
 * @ClassName: ChoosingTimeMapper
 * @author 
 * @date 2013-05-11 01:58:59
 *
 */

public interface ChoosingTimeMapper{

	/**
	 *
	 * @Title insertChoosingTime
	 * @Description 向数据表choosing_time中插入一条ChoosingTime记录
	 * @param choosingTime
	 * @return int
	 */
	public int insertChoosingTime(ChoosingTime choosingTime);

	/**
	 *
	 * @Title deleteChoosingTime
	 * @Description 从数据表choosing_time中,根据传入参数做条件,删除一条ChoosingTime记录
	 * @param choosingTime
	 * @return int
	 */
	public int deleteChoosingTime(ChoosingTime choosingTime);

	/**
	 *
	 * @Title updateChoosingTime
	 * @Description 从数据表choosing_time中,根据Id,更新一条ChoosingTime记录
	 * @param choosingTime
	 * @return int
	 */
	public int updateChoosingTime(ChoosingTime choosingTime);

	/**
	 *
	 * @Title nestedSelectChoosingTime
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param choosingTime
	 * @return List<ChoosingTime>
	 */
	public List<ChoosingTime> nestedSelectChoosingTime(ChoosingTime choosingTime);

}