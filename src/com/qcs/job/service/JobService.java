package com.qcs.job.service;

import java.util.List;

import com.qcs.base.exception.BusinessException;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.job.pojo.Job;

public interface JobService {

	public int add(Job job) throws BusinessException;
	
	public int delete(Job job) throws BusinessException;
	
	public int update(Job job) throws BusinessException;
	
	public List<Job> query(Job job)throws BusinessException;
	
	public PaginationResult<Job> query(Job job,PaginationInfo pageInfo)throws BusinessException;
}
