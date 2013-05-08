package com.qcs.job.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.qcs.base.pagination.PaginationContext;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.job.dao.JobDao;
import com.qcs.job.mapper.JobMapper;
import com.qcs.job.pojo.Job;

/**
 *
 * @ClassName: JobDaoImpl
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */
@Repository
public class JobDaoImpl implements JobDao{
	/**
	*	Job映射的mapper
	*/
	@Autowired
	private JobMapper jobMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据Job的属性。往数据表job插入一条新记录
	 * @param job
	 * @return int
	 */
	public int add(Job job) throws DataAccessException{

		return jobMapper.insertJob(job);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据Job的属性,删除数据表job一条记录
	 * @param job
	 * @return int
	 */
	public int delete(Job job) throws DataAccessException{

		return jobMapper.deleteJob(job);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据Job的主键,更新数据表job一条记录
	 * @param job
	 * @return int
	 */
	public int update(Job job) throws DataAccessException{

		return jobMapper.updateJob(job);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数job的属性做条件,查询数据表job的记录。
	 * @param job
	 * @return List<Job>
	 */
	public List<Job> query(Job job) throws DataAccessException{

		return jobMapper.nestedSelectJob(job);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param job
	 * @param pageInfo
	 * @return PaginationResult<Job>
	 */
	public PaginationResult<Job> query(Job job,PaginationInfo pageInfo) throws DataAccessException{

		PaginationContext.set(pageInfo);
		PaginationResult<Job> pageResult = new PaginationResult<Job>();
		pageResult.setData(query(job));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getJobMapper
	 * @Description 返回jobMapper的值
	 * @return JobMapper
	 */
	public JobMapper getJobMapper(){

		return this.jobMapper;

	}
	/**
	 *
	 * @Title setJobMapper
	 * @Description 设置jobMapper的值
	 * @param jobMapper
	 * @return void
	 */
	public void setJobMapper(JobMapper jobMapper){

		this.jobMapper = jobMapper;

	}
}