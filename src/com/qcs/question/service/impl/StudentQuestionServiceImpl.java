package com.qcs.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcs.base.exception.BusinessException;
import com.qcs.question.dao.StudentQuestionDao;
import com.qcs.question.pojo.StudentQuestion;
import com.qcs.question.service.StudentQuestionService;

@Service
public class StudentQuestionServiceImpl implements StudentQuestionService {

	@Autowired
	private StudentQuestionDao studentQuestionDao;
	
	@Override
	public int add(StudentQuestion studentQuestion) throws BusinessException {
		return this.studentQuestionDao.add(studentQuestion);
	}

	@Override
	public int delete(StudentQuestion studentQuestion) throws BusinessException {
		return this.studentQuestionDao.delete(studentQuestion);
	}

	@Override
	public int update(StudentQuestion studentQuestion) throws BusinessException {
		return this.studentQuestionDao.update(studentQuestion);
	}

	@Override
	public List<StudentQuestion> query(StudentQuestion studentQuestion)
			throws BusinessException {
		return this.studentQuestionDao.query(studentQuestion);
	}

	public StudentQuestionDao getStudentQuestionDao() {
		return studentQuestionDao;
	}

	public void setStudentQuestionDao(StudentQuestionDao studentQuestionDao) {
		this.studentQuestionDao = studentQuestionDao;
	}

}
