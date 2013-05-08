package com.qcs.teacher.pojo;

import com.qcs.user.pojo.User;
import com.qcs.job.pojo.Job;
import com.qcs.question.pojo.Question;
import java.util.List;

/**
 *
 * @ClassName: Teacher
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class Teacher{
	private Integer id;
	private Integer userId;
	/**
	*	教工号
	*/
	private String teacherNo;
	/**
	*	邮箱
	*/
	private String email;
	/**
	*	姓名
	*/
	private String name;
	/**
	*	性别
0：女
1：男
	*/
	private String gender;
	/**
	*	出生日期
	*/
	private String birthDate;
	/**
	*	部门(院校)
	*/
	private String department;
	/**
	*	学历
	*/
	private String education;
	/**
	*	学位
	*/
	private String degree;
	/**
	*	职务
	*/
	private String job;
	/**
	*	职称
	*/
	private String jobTitle;
	/**
	*	专业
	*/
	private String major;
	/**
	*	毕业院校
	*/
	private String graduated;
	/**
	*	教师资格
	*/
	private String teacherCert;
	/**
	*	备注
	*/
	private String remark;
	private User user;
	private Job refJob;
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
	 * @Title getTeacherNo
	 * @Description 返回teacherNo的值
	 * @return String
	 */
	public String getTeacherNo(){

		return this.teacherNo;

	}
	/**
	 *
	 * @Title setTeacherNo
	 * @Description 设置teacherNo的值
	 * @param teacherNo
	 * @return void
	 */
	public void setTeacherNo(String teacherNo){

		this.teacherNo = teacherNo;

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
	 * @Title getBirthDate
	 * @Description 返回birthDate的值
	 * @return String
	 */
	public String getBirthDate(){

		return this.birthDate;

	}
	/**
	 *
	 * @Title setBirthDate
	 * @Description 设置birthDate的值
	 * @param birthDate
	 * @return void
	 */
	public void setBirthDate(String birthDate){

		this.birthDate = birthDate;

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
	 * @Title getEducation
	 * @Description 返回education的值
	 * @return String
	 */
	public String getEducation(){

		return this.education;

	}
	/**
	 *
	 * @Title setEducation
	 * @Description 设置education的值
	 * @param education
	 * @return void
	 */
	public void setEducation(String education){

		this.education = education;

	}
	/**
	 *
	 * @Title getDegree
	 * @Description 返回degree的值
	 * @return String
	 */
	public String getDegree(){

		return this.degree;

	}
	/**
	 *
	 * @Title setDegree
	 * @Description 设置degree的值
	 * @param degree
	 * @return void
	 */
	public void setDegree(String degree){

		this.degree = degree;

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
	 * @Title getJobTitle
	 * @Description 返回jobTitle的值
	 * @return String
	 */
	public String getJobTitle(){

		return this.jobTitle;

	}
	/**
	 *
	 * @Title setJobTitle
	 * @Description 设置jobTitle的值
	 * @param jobTitle
	 * @return void
	 */
	public void setJobTitle(String jobTitle){

		this.jobTitle = jobTitle;

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
	 * @Title getGraduated
	 * @Description 返回graduated的值
	 * @return String
	 */
	public String getGraduated(){

		return this.graduated;

	}
	/**
	 *
	 * @Title setGraduated
	 * @Description 设置graduated的值
	 * @param graduated
	 * @return void
	 */
	public void setGraduated(String graduated){

		this.graduated = graduated;

	}
	/**
	 *
	 * @Title getTeacherCert
	 * @Description 返回teacherCert的值
	 * @return String
	 */
	public String getTeacherCert(){

		return this.teacherCert;

	}
	/**
	 *
	 * @Title setTeacherCert
	 * @Description 设置teacherCert的值
	 * @param teacherCert
	 * @return void
	 */
	public void setTeacherCert(String teacherCert){

		this.teacherCert = teacherCert;

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
	 * @Title getRefJob
	 * @Description 返回refJob的值
	 * @return Job
	 */
	public Job getRefJob(){

		return this.refJob;

	}
	/**
	 *
	 * @Title setRefJob
	 * @Description 设置refJob的值
	 * @param refJob
	 * @return void
	 */
	public void setRefJob(Job refJob){

		this.refJob = refJob;

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