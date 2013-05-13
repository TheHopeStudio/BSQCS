package com.qcs.question.service;

import java.util.List;

import com.qcs.base.exception.BusinessException;
import com.qcs.question.pojo.ChoosingTime;

public interface ChoosingTimeService {
	
	public int add(ChoosingTime choosingTime) throws BusinessException;
	
	public int delete(ChoosingTime choosingTime) throws BusinessException;
	
	public int update(ChoosingTime choosingTime) throws BusinessException;
	
	public List<ChoosingTime> query(ChoosingTime choosingTime) throws BusinessException;

	public List<ChoosingTime> queryChoosingTimeInNow();
}
