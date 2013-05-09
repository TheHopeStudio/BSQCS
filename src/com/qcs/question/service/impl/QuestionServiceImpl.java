package com.qcs.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcs.base.exception.BusinessException;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.question.dao.QuestionDao;
import com.qcs.question.pojo.Question;
import com.qcs.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public int add(Question question) throws BusinessException {
		return questionDao.add(question);
	}

	@Override
	public int delete(Question question) throws BusinessException {
		return questionDao.delete(question);
	}

	@Override
	public int update(Question question) throws BusinessException {
		return questionDao.update(question);
	}

	@Override
	public List<Question> query(Question question) throws BusinessException {
		return questionDao.query(question);
	}

	@Override
	public PaginationResult<Question> query(Question question,
			PaginationInfo pageInfo) throws BusinessException {
		return questionDao.query(question, pageInfo);
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public List<Question> query(Question question, boolean join)
			throws BusinessException {
		return this.questionDao.query(question, join);
	}

	@Override
	public PaginationResult<Question> query(Question question,
			PaginationInfo pageInfo, boolean join) throws BusinessException {
		return this.questionDao.query(question, pageInfo,join);
	}

}
