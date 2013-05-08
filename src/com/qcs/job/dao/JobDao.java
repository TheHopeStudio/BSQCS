package com.qcs.job.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.job.pojo.Job;

/**
 *
 * @ClassName: JobDao
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface JobDao{

	/**
	 *
	 * @Title add
	 * @Description 根据Job的属性。往数据表job插入一条新记录
	 * @param job
	 * @return int
	 */
	public int add(Job job) throws DataAccessException;

	/**
	 *
	 * @Title delete
	 * @Description 根据Job的属性,删除数据表job一条记录
	 * @param job
	 * @return int
	 */
	public int delete(Job job) throws DataAccessException;

	/**
	 *
	 * @Title update
	 * @Description 根据Job的主键,更新数据表job一条记录
	 * @param job
	 * @return int
	 */
	public int update(Job job) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 根据参数job的属性做条件,查询数据表job的记录。
	 * @param job
	 * @return List<Job>
	 */
	public List<Job> query(Job job) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param job
	 * @param pageInfo
	 * @return PaginationResult<Job>
	 */
	public PaginationResult<Job> query(Job job,PaginationInfo pageInfo) throws DataAccessException;

}