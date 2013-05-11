package com.qcs.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcs.base.exception.BusinessException;
import com.qcs.question.dao.ChoosingTimeDao;
import com.qcs.question.pojo.ChoosingTime;
import com.qcs.question.service.ChoosingTimeService;

@Service
public class ChoosingTimeServiceImpl implements ChoosingTimeService {

	@Autowired
	private ChoosingTimeDao choosingTimeDao;
	
	@Override
	public int add(ChoosingTime choosingTime) throws BusinessException {
		return choosingTimeDao.add(choosingTime);
	}

	@Override
	public int delete(ChoosingTime choosingTime) throws BusinessException {
		return choosingTimeDao.delete(choosingTime);
	}

	@Override
	public int update(ChoosingTime choosingTime) throws BusinessException {
		return this.choosingTimeDao.update(choosingTime);
	}

	@Override
	public List<ChoosingTime> query(ChoosingTime choosingTime)
			throws BusinessException {
		return this.choosingTimeDao.query(choosingTime);
	}

}
