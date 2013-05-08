package com.qcs.teacher.service;

import java.io.File;
import java.util.List;

import com.qcs.base.exception.BusinessException;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.teacher.pojo.Teacher;

public interface TeacherService {

	public int add(Teacher t) throws BusinessException;
	
	public int delete(Teacher t)throws BusinessException;
	
	public int update(Teacher t)throws BusinessException;
	
	public List<Teacher> query(Teacher t)throws BusinessException;
	
	public List<Teacher> query(Teacher t,boolean join)throws BusinessException;
	
	public PaginationResult<Teacher> query(Teacher t,PaginationInfo pageInfo)throws BusinessException;
	
	public PaginationResult<Teacher> query(Teacher t,PaginationInfo pageInfo,boolean join)throws BusinessException;

	public void importTeachers(File uploadFile) throws BusinessException;
	
	
}
