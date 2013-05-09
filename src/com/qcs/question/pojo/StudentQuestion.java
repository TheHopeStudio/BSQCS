package com.qcs.question.pojo;


/**
 *
 * @ClassName: StudentQuestion
 * @author 
 * @date 2013-05-09 09:52:49
 *
 */

public class StudentQuestion{
	private Integer questionId;
	private Integer studentId;

	/**
	 *
	 * @Title getQuestionId
	 * @Description 返回questionId的值
	 * @return Integer
	 */
	public Integer getQuestionId(){

		return this.questionId;

	}
	/**
	 *
	 * @Title setQuestionId
	 * @Description 设置questionId的值
	 * @param questionId
	 * @return void
	 */
	public void setQuestionId(Integer questionId){

		this.questionId = questionId;

	}
	/**
	 *
	 * @Title getStudentId
	 * @Description 返回studentId的值
	 * @return Integer
	 */
	public Integer getStudentId(){

		return this.studentId;

	}
	/**
	 *
	 * @Title setStudentId
	 * @Description 设置studentId的值
	 * @param studentId
	 * @return void
	 */
	public void setStudentId(Integer studentId){

		this.studentId = studentId;

	}
}