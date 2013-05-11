package com.qcs.question.pojo;

import java.util.Date;
import com.qcs.student.pojo.Student;
import java.util.List;

/**
 *
 * @ClassName: Question
 * @author 
 * @date 2013-05-11 10:05:56
 *
 */

public class Question{
	private Integer id;
	private Integer studentId;
	/**
	*	出题教师id
	*/
	private Integer teacherId;
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
	*	是否存活（未被选中）
	*/
	private Object live;
	/**
	*	被选时间
	*/
	private Date chooseTime;
	/**
	*	被选时间
	*/
	private Date startTime;
	/**
	*	被选时间
	*/
	private Date endTime;
	private Student student;
	private List<Student> selectionStudents;

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
	/**
	 *
	 * @Title getTeacherId
	 * @Description 返回teacherId的值
	 * @return Integer
	 */
	public Integer getTeacherId(){

		return this.teacherId;

	}
	/**
	 *
	 * @Title setTeacherId
	 * @Description 设置teacherId的值
	 * @param teacherId
	 * @return void
	 */
	public void setTeacherId(Integer teacherId){

		this.teacherId = teacherId;

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
	/**
	 *
	 * @Title getLive
	 * @Description 返回live的值
	 * @return Object
	 */
	public Object getLive(){

		return this.live;

	}
	/**
	 *
	 * @Title setLive
	 * @Description 设置live的值
	 * @param live
	 * @return void
	 */
	public void setLive(Object live){

		this.live = live;

	}
	/**
	 *
	 * @Title getChooseTime
	 * @Description 返回chooseTime的值
	 * @return Date
	 */
	public Date getChooseTime(){

		return this.chooseTime;

	}
	/**
	 *
	 * @Title setChooseTime
	 * @Description 设置chooseTime的值
	 * @param chooseTime
	 * @return void
	 */
	public void setChooseTime(Date chooseTime){

		this.chooseTime = chooseTime;

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
	 * @Title getStudent
	 * @Description 返回student的值
	 * @return Student
	 */
	public Student getStudent(){

		return this.student;

	}
	/**
	 *
	 * @Title setStudent
	 * @Description 设置student的值
	 * @param student
	 * @return void
	 */
	public void setStudent(Student student){

		this.student = student;

	}
	/**
	 *
	 * @Title getSelectionStudents
	 * @Description 返回selectionStudents的值
	 * @return List<Student>
	 */
	public List<Student> getSelectionStudents(){

		return this.selectionStudents;

	}
	/**
	 *
	 * @Title setSelectionStudents
	 * @Description 设置selectionStudents的值
	 * @param selectionStudents
	 * @return void
	 */
	public void setSelectionStudents(List<Student> selectionStudents){

		this.selectionStudents = selectionStudents;

	}
}