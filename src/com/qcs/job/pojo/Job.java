package com.qcs.job.pojo;


/**
 *
 * @ClassName: Job
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class Job{
	private Integer id;
	/**
	*	职务
当与教室表的job字段匹配时候
教师可以出题并且有数量限制
	*/
	private String job;
	/**
	*	出题数量
	*/
	private Integer questionNum;

	/**
	 *
	 * @Title getId
	 * @Description 返回id的值
	 * @return Integer
	 */
	public Integer getId(){

		return this.id;

	}
	/**
	 *
	 * @Title setId
	 * @Description 设置id的值
	 * @param id
	 * @return void
	 */
	public void setId(Integer id){

		this.id = id;

	}
	/**
	 *
	 * @Title getJob
	 * @Description 返回job的值
	 * @return String
	 */
	public String getJob(){

		return this.job;

	}
	/**
	 *
	 * @Title setJob
	 * @Description 设置job的值
	 * @param job
	 * @return void
	 */
	public void setJob(String job){

		this.job = job;

	}
	/**
	 *
	 * @Title getQuestionNum
	 * @Description 返回questionNum的值
	 * @return Integer
	 */
	public Integer getQuestionNum(){

		return this.questionNum;

	}
	/**
	 *
	 * @Title setQuestionNum
	 * @Description 设置questionNum的值
	 * @param questionNum
	 * @return void
	 */
	public void setQuestionNum(Integer questionNum){

		this.questionNum = questionNum;

	}
}