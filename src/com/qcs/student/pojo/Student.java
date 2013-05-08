package com.qcs.student.pojo;

import com.qcs.user.pojo.User;
import com.qcs.question.pojo.Question;
import java.util.List;

/**
 *
 * @ClassName: Student
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class Student{
	private Integer id;
	private Integer userId;
	/**
	*	学号
	*/
	private String studentNo;
	/**
	*	邮箱
	*/
	private String email;
	private User user;
	private List<Question> questions;

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
	 * @Title getUserId
	 * @Description 返回userId的值
	 * @return Integer
	 */
	public Integer getUserId(){

		return this.userId;

	}
	/**
	 *
	 * @Title setUserId
	 * @Description 设置userId的值
	 * @param userId
	 * @return void
	 */
	public void setUserId(Integer userId){

		this.userId = userId;

	}
	/**
	 *
	 * @Title getStudentNo
	 * @Description 返回studentNo的值
	 * @return String
	 */
	public String getStudentNo(){

		return this.studentNo;

	}
	/**
	 *
	 * @Title setStudentNo
	 * @Description 设置studentNo的值
	 * @param studentNo
	 * @return void
	 */
	public void setStudentNo(String studentNo){

		this.studentNo = studentNo;

	}
	/**
	 *
	 * @Title getEmail
	 * @Description 返回email的值
	 * @return String
	 */
	public String getEmail(){

		return this.email;

	}
	/**
	 *
	 * @Title setEmail
	 * @Description 设置email的值
	 * @param email
	 * @return void
	 */
	public void setEmail(String email){

		this.email = email;

	}
	/**
	 *
	 * @Title getUser
	 * @Description 返回user的值
	 * @return User
	 */
	public User getUser(){

		return this.user;

	}
	/**
	 *
	 * @Title setUser
	 * @Description 设置user的值
	 * @param user
	 * @return void
	 */
	public void setUser(User user){

		this.user = user;

	}
	/**
	 *
	 * @Title getQuestions
	 * @Description 返回questions的值
	 * @return List<Question>
	 */
	public List<Question> getQuestions(){

		return this.questions;

	}
	/**
	 *
	 * @Title setQuestions
	 * @Description 设置questions的值
	 * @param questions
	 * @return void
	 */
	public void setQuestions(List<Question> questions){

		this.questions = questions;

	}
}