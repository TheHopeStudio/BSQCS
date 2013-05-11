package com.qcs.question.service;

import java.util.List;

import com.qcs.base.exception.BusinessException;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.question.pojo.Question;

public interface QuestionService {
	
	public int add(Question question)throws BusinessException;
	
	public int delete(Question question) throws BusinessException;
	
	public int update(Question question) throws BusinessException;
	
	public List<Question> query(Question question) throws BusinessException;
	
	public List<Question> query(Question question,boolean join) throws BusinessException;
	
	public PaginationResult<Question> query(Question question,PaginationInfo pageInfo) throws BusinessException;
	
	public PaginationResult<Question> query(Question question,PaginationInfo pageInfo,boolean join) throws BusinessException;

	public List<Question> queryNotChoose(Integer integer) throws BusinessException;
}
