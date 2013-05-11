package com.qcs.question.pojo;

import java.util.Date;

/**
 *
 * @ClassName: ChoosingTime
 * @author 
 * @date 2013-05-11 01:50:58
 *
 */

public class ChoosingTime{
	private Integer id;
	/**
	*	名称
	*/
	private String name;
	/**
	*	选题起始时间
	*/
	private Date startTime;
	/**
	*	选题结束时间
	*/
	private Date endTime;
	/**
	*	状态 0：不启用  1：启用
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
	 * @Title getName
	 * @Description 返回name的值
	 * @return String
	 */
	public String getName(){

		return this.name;

	}
	/**
	 *
	 * @Title setName
	 * @Description 设置name的值
	 * @param name
	 * @return void
	 */
	public void setName(String name){

		this.name = name;

	}
	/**
	 *
	 * @Title getStartTime
	 * @Description 返回startTime的值
	 * @return Date
	 */
	public Date getStartTime(){

		return this.startTime;

	}
	/**
	 *
	 * @Title setStartTime
	 * @Description 设置startTime的值
	 * @param startTime
	 * @return void
	 */
	public void setStartTime(Date startTime){

		this.startTime = startTime;

	}
	/**
	 *
	 * @Title getEndTime
	 * @Description 返回endTime的值
	 * @return Date
	 */
	public Date getEndTime(){

		return this.endTime;

	}
	/**
	 *
	 * @Title setEndTime
	 * @Description 设置endTime的值
	 * @param endTime
	 * @return void
	 */
	public void setEndTime(Date endTime){

		this.endTime = endTime;

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