package com.qcs.question.dao.impl;

import com.qcs.question.dao.StudentQuestionDao;
import com.qcs.question.mapper.StudentQuestionMapper;
import com.qcs.question.pojo.StudentQuestion;
import com.qcs.question.service.StudentQuestionService;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: StudentQuestionDaoImpl
 * @author 
 * @date 2013-05-09 09:52:50
 *
 */

@Repository
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
	public int add(StudentQuestion studentQuestion){

		return studentQuestionMapper.insertStudentQuestion(studentQuestion);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据StudentQuestion的属性,删除数据表student_question一条记录
	 * @param studentQuestion
	 * @return int
	 */
	public int delete(StudentQuestion studentQuestion){

		return studentQuestionMapper.deleteStudentQuestion(studentQuestion);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据StudentQuestion的主键,更新数据表student_question一条记录
	 * @param studentQuestion
	 * @return int
	 */
	public int update(StudentQuestion studentQuestion){

		return studentQuestionMapper.updateStudentQuestion(studentQuestion);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数studentQuestion的属性做条件,查询数据表student_question的记录。
	 * @param studentQuestion
	 * @return List<StudentQuestion>
	 */
	public List<StudentQuestion> query(StudentQuestion studentQuestion){

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
	public PaginationResult<StudentQuestion> query(StudentQuestion studentQuestion,PaginationInfo pageInfo){

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
	@Override
	public List<StudentQuestion> queryInComplete() {
		return this.studentQuestionMapper.queryInComplete();
	}
}