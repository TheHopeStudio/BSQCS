package com.qcs.student.pojo;

import com.qcs.user.pojo.User;
import com.qcs.question.pojo.Question;
import java.util.List;

/**
 *
 * @ClassName: Student
 * @author 
 * @date 2013-05-11 09:17:44
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
	/**
	*	姓名
	*/
	private String name;
	/**
	*	0：女 1：男
	*/
	private String gender;
	/**
	*	电话
	*/
	private String telphone;
	/**
	*	学院
	*/
	private String department;
	/**
	*	专业
	*/
	private String major;
	/**
	*	行政班
	*/
	private String classes;
	/**
	*	年级
	*/
	private String grade;
	/**
	*	出生日期
	*/
	private String birthdate;
	/**
	*	成绩1
	*/
	private Double score1;
	/**
	*	成绩2
	*/
	private Double score2;
	/**
	*	成绩3
	*/
	private Double score3;
	/**
	*	成绩4
	*/
	private Double score4;
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
	 * @Title getGender
	 * @Description 返回gender的值
	 * @return String
	 */
	public String getGender(){

		return this.gender;

	}
	/**
	 *
	 * @Title setGender
	 * @Description 设置gender的值
	 * @param gender
	 * @return void
	 */
	public void setGender(String gender){

		this.gender = gender;

	}
	/**
	 *
	 * @Title getTelphone
	 * @Description 返回telphone的值
	 * @return String
	 */
	public String getTelphone(){

		return this.telphone;

	}
	/**
	 *
	 * @Title setTelphone
	 * @Description 设置telphone的值
	 * @param telphone
	 * @return void
	 */
	public void setTelphone(String telphone){

		this.telphone = telphone;

	}
	/**
	 *
	 * @Title getDepartment
	 * @Description 返回department的值
	 * @return String
	 */
	public String getDepartment(){

		return this.department;

	}
	/**
	 *
	 * @Title setDepartment
	 * @Description 设置department的值
	 * @param department
	 * @return void
	 */
	public void setDepartment(String department){

		this.department = department;

	}
	/**
	 *
	 * @Title getMajor
	 * @Description 返回major的值
	 * @return String
	 */
	public String getMajor(){

		return this.major;

	}
	/**
	 *
	 * @Title setMajor
	 * @Description 设置major的值
	 * @param major
	 * @return void
	 */
	public void setMajor(String major){

		this.major = major;

	}
	/**
	 *
	 * @Title getClasses
	 * @Description 返回classes的值
	 * @return String
	 */
	public String getClasses(){

		return this.classes;

	}
	/**
	 *
	 * @Title setClasses
	 * @Description 设置classes的值
	 * @param classes
	 * @return void
	 */
	public void setClasses(String classes){

		this.classes = classes;

	}
	/**
	 *
	 * @Title getGrade
	 * @Description 返回grade的值
	 * @return String
	 */
	public String getGrade(){

		return this.grade;

	}
	/**
	 *
	 * @Title setGrade
	 * @Description 设置grade的值
	 * @param grade
	 * @return void
	 */
	public void setGrade(String grade){

		this.grade = grade;

	}
	/**
	 *
	 * @Title getBirthdate
	 * @Description 返回birthdate的值
	 * @return String
	 */
	public String getBirthdate(){

		return this.birthdate;

	}
	/**
	 *
	 * @Title setBirthdate
	 * @Description 设置birthdate的值
	 * @param birthdate
	 * @return void
	 */
	public void setBirthdate(String birthdate){

		this.birthdate = birthdate;

	}
	/**
	 *
	 * @Title getScore1
	 * @Description 返回score1的值
	 * @return Double
	 */
	public Double getScore1(){

		return this.score1;

	}
	/**
	 *
	 * @Title setScore1
	 * @Description 设置score1的值
	 * @param score1
	 * @return void
	 */
	public void setScore1(Double score1){

		this.score1 = score1;

	}
	/**
	 *
	 * @Title getScore2
	 * @Description 返回score2的值
	 * @return Double
	 */
	public Double getScore2(){

		return this.score2;

	}
	/**
	 *
	 * @Title setScore2
	 * @Description 设置score2的值
	 * @param score2
	 * @return void
	 */
	public void setScore2(Double score2){

		this.score2 = score2;

	}
	/**
	 *
	 * @Title getScore3
	 * @Description 返回score3的值
	 * @return Double
	 */
	public Double getScore3(){

		return this.score3;

	}
	/**
	 *
	 * @Title setScore3
	 * @Description 设置score3的值
	 * @param score3
	 * @return void
	 */
	public void setScore3(Double score3){

		this.score3 = score3;

	}
	/**
	 *
	 * @Title getScore4
	 * @Description 返回score4的值
	 * @return Double
	 */
	public Double getScore4(){

		return this.score4;

	}
	/**
	 *
	 * @Title setScore4
	 * @Description 设置score4的值
	 * @param score4
	 * @return void
	 */
	public void setScore4(Double score4){

		this.score4 = score4;

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