package com.qcs.student.service;

import java.io.File;
import java.util.List;

import com.qcs.base.exception.BusinessException;
import com.qcs.student.pojo.Student;

public interface StudentService {
	
	public int add(Student student) throws BusinessException;
	
	public int delete(Student student) throws BusinessException;
	
	public int update(Student student) throws BusinessException;
	
	public List<Student> query(Student student) throws BusinessException;

	public List<Student> query(Student student,boolean join) throws BusinessException;
	public void insertStudent(File uploadFile)throws BusinessException;

	public List<Student> queryStudentWhichNoQuestion()throws BusinessException;
}
