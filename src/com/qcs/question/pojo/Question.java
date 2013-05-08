package com.qcs.question.pojo;


/**
 *
 * @ClassName: Question
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class Question{
	private Integer id;
	/**
	*	出题教师id
	*/
	private Integer teacherInfoId;
	private String title;
	private String content;
	private String remark;
	/**
	*	状态
0：审核中
1：通过
2：不通过
	*/
	private String state;

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
	 * @Title getTeacherInfoId
	 * @Description 返回teacherInfoId的值
	 * @return Integer
	 */
	public Integer getTeacherInfoId(){

		return this.teacherInfoId;

	}
	/**
	 *
	 * @Title setTeacherInfoId
	 * @Description 设置teacherInfoId的值
	 * @param teacherInfoId
	 * @return void
	 */
	public void setTeacherInfoId(Integer teacherInfoId){

		this.teacherInfoId = teacherInfoId;

	}
	/**
	 *
	 * @Title getTitle
	 * @Description 返回title的值
	 * @return String
	 */
	public String getTitle(){

		return this.title;

	}
	/**
	 *
	 * @Title setTitle
	 * @Description 设置title的值
	 * @param title
	 * @return void
	 */
	public void setTitle(String title){

		this.title = title;

	}
	/**
	 *
	 * @Title getContent
	 * @Description 返回content的值
	 * @return String
	 */
	public String getContent(){

		return this.content;

	}
	/**
	 *
	 * @Title setContent
	 * @Description 设置content的值
	 * @param content
	 * @return void
	 */
	public void setContent(String content){

		this.content = content;

	}
	/**
	 *
	 * @Title getRemark
	 * @Description 返回remark的值
	 * @return String
	 */
	public String getRemark(){

		return this.remark;

	}
	/**
	 *
	 * @Title setRemark
	 * @Description 设置remark的值
	 * @param remark
	 * @return void
	 */
	public void setRemark(String remark){

		this.remark = remark;

	}
	/**
	 *
	 * @Title getState
	 * @Description 返回state的值
	 * @return String
	 */
	public String getState(){

		return this.state;

	}
	/**
	 *
	 * @Title setState
	 * @Description 设置state的值
	 * @param state
	 * @return void
	 */
	public void setState(String state){

		this.state = state;

	}
}