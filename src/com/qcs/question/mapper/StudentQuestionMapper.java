package com.qcs.question.mapper;

import com.qcs.question.pojo.StudentQuestion;
import com.qcs.question.service.StudentQuestionService;

import java.util.List;

/**
 *
 * @ClassName: StudentQuestionMapper
 * @author 
 * @date 2013-05-09 09:52:50
 *
 */

public interface StudentQuestionMapper{

	/**
	 *
	 * @Title insertStudentQuestion
	 * @Description 向数据表student_question中插入一条StudentQuestion记录
	 * @param studentQuestion
	 * @return int
	 */
	public int insertStudentQuestion(StudentQuestion studentQuestion);

	/**
	 *
	 * @Title deleteStudentQuestion
	 * @Description 从数据表student_question中,根据传入参数做条件,删除一条StudentQuestion记录
	 * @param studentQuestion
	 * @return int
	 */
	public int deleteStudentQuestion(StudentQuestion studentQuestion);

	/**
	 *
	 * @Title updateStudentQuestion
	 * @Description 从数据表student_question中,根据Id,更新一条StudentQuestion记录
	 * @param studentQuestion
	 * @return int
	 */
	public int updateStudentQuestion(StudentQuestion studentQuestion);

	/**
	 *
	 * @Title nestedSelectStudentQuestion
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param studentQuestion
	 * @return List<StudentQuestion>
	 */
	public List<StudentQuestion> nestedSelectStudentQuestion(StudentQuestion studentQuestion);


	public List<StudentQuestion> queryInComplete();

}