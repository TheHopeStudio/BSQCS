package com.qcs.job.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcs.base.exception.BusinessException;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.job.dao.JobDao;
import com.qcs.job.pojo.Job;
import com.qcs.job.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;
	
	@Override
	public int add(Job job) throws BusinessException {
		return jobDao.add(job);
	}

	@Override
	public int delete(Job job) throws BusinessException {
		return jobDao.delete(job);
	}

	@Override
	public int update(Job job) throws BusinessException {
		return jobDao.update(job);
	}

	@Override
	public List<Job> query(Job job) throws BusinessException {
		return jobDao.query(job);
	}

	@Override
	public PaginationResult<Job> query(Job job, PaginationInfo pageInfo)
			throws BusinessException {
		return jobDao.query(job, pageInfo);
	}

	public JobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

}
