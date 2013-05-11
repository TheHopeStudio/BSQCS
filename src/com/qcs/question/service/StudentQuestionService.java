package com.qcs.question.service;

import java.util.List;

import com.qcs.base.exception.BusinessException;
import com.qcs.question.pojo.StudentQuestion;

public interface StudentQuestionService {

	public int add(StudentQuestion studentQuestion) throws BusinessException;
	
	public int delete(StudentQuestion studentQuestion) throws BusinessException;
	
	public int update(StudentQuestion studentQuestion) throws BusinessException;
	
	public List<StudentQuestion> query(StudentQuestion studentQuestion) throws BusinessException;
}
