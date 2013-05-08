package com.qcs.question.dao.impl;

import com.qcs.question.dao.StudentQuestionDao;
import com.qcs.question.mapper.StudentQuestionMapper;
import com.qcs.question.pojo.StudentQuestion;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: StudentQuestionDaoImpl
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class StudentQuestionDaoImpl implements StudentQuestionDao{
	/**
	*	StudentQuestion映射的mapper
	*/
	private StudentQuestionMapper studentQuestionMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据StudentQuestion的属性。往数据表student_question插入一条新记录
	 * @param studentQuestion
	 * @return int
	 */
	public int add(StudentQuestion studentQuestion) throws DataAccessException{

		return studentQuestionMapper.insertStudentQuestion(studentQuestion);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据StudentQuestion的属性,删除数据表student_question一条记录
	 * @param studentQuestion
	 * @return int
	 */
	public int delete(StudentQuestion studentQuestion) throws DataAccessException{

		return studentQuestionMapper.deleteStudentQuestion(studentQuestion);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据StudentQuestion的主键,更新数据表student_question一条记录
	 * @param studentQuestion
	 * @return int
	 */
	public int update(StudentQuestion studentQuestion) throws DataAccessException{

		return studentQuestionMapper.updateStudentQuestion(studentQuestion);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数studentQuestion的属性做条件,查询数据表student_question的记录。
	 * @param studentQuestion
	 * @return List<StudentQuestion>
	 */
	public List<StudentQuestion> query(StudentQuestion studentQuestion) throws DataAccessException{

		return studentQuestionMapper.nestedSelectStudentQuestion(studentQuestion);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param studentQuestion
	 * @param pageInfo
	 * @return PaginationResult<StudentQuestion>
	 */
	public PaginationResult<StudentQuestion> query(StudentQuestion studentQuestion,PaginationInfo pageInfo) throws DataAccessException{

		PaginationContext.set(pageInfo);
		PaginationResult<StudentQuestion> pageResult = new PaginationResult<StudentQuestion>();
		pageResult.setData(query(studentQuestion));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getStudentQuestionMapper
	 * @Description 返回studentQuestionMapper的值
	 * @return StudentQuestionMapper
	 */
	public StudentQuestionMapper getStudentQuestionMapper(){

		return this.studentQuestionMapper;

	}
	/**
	 *
	 * @Title setStudentQuestionMapper
	 * @Description 设置studentQuestionMapper的值
	 * @param studentQuestionMapper
	 * @return void
	 */
	public void setStudentQuestionMapper(StudentQuestionMapper studentQuestionMapper){

		this.studentQuestionMapper = studentQuestionMapper;

	}
}