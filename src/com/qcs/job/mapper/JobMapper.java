package com.qcs.job.mapper;

import com.qcs.job.pojo.Job;
import java.util.List;

/**
 *
 * @ClassName: JobMapper
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface JobMapper{

	/**
	 *
	 * @Title insertJob
	 * @Description 向数据表job中插入一条Job记录
	 * @param job
	 * @return int
	 */
	public int insertJob(Job job);

	/**
	 *
	 * @Title deleteJob
	 * @Description 从数据表job中,根据传入参数做条件,删除一条Job记录
	 * @param job
	 * @return int
	 */
	public int deleteJob(Job job);

	/**
	 *
	 * @Title updateJob
	 * @Description 从数据表job中,根据Id,更新一条Job记录
	 * @param job
	 * @return int
	 */
	public int updateJob(Job job);

	/**
	 *
	 * @Title nestedSelectJob
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param job
	 * @return List<Job>
	 */
	public List<Job> nestedSelectJob(Job job);

}