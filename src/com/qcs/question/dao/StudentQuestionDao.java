package com.qcs.question.dao;

import com.qcs.question.pojo.StudentQuestion;
import com.qcs.question.service.StudentQuestionService;

import java.util.List;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: StudentQuestionDao
 * @author 
 * @date 2013-05-09 09:52:50
 *
 */

public interface StudentQuestionDao{

	/**
	 *
	 * @Title add
	 * @Description 根据StudentQuestion的属性。往数据表student_question插入一条新记录
	 * @param studentQuestion
	 * @return int
	 */
	public int add(StudentQuestion studentQuestion);

	/**
	 *
	 * @Title delete
	 * @Description 根据StudentQuestion的属性,删除数据表student_question一条记录
	 * @param studentQuestion
	 * @return int
	 */
	public int delete(StudentQuestion studentQuestion);

	/**
	 *
	 * @Title update
	 * @Description 根据StudentQuestion的主键,更新数据表student_question一条记录
	 * @param studentQuestion
	 * @return int
	 */
	public int update(StudentQuestion studentQuestion);

	/**
	 *
	 * @Title query
	 * @Description 根据参数studentQuestion的属性做条件,查询数据表student_question的记录。
	 * @param studentQuestion
	 * @return List<StudentQuestion>
	 */
	public List<StudentQuestion> query(StudentQuestion studentQuestion);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param studentQuestion
	 * @param pageInfo
	 * @return PaginationResult<StudentQuestion>
	 */
	public PaginationResult<StudentQuestion> query(StudentQuestion studentQuestion,PaginationInfo pageInfo);

	public List<StudentQuestion> queryInComplete();

}