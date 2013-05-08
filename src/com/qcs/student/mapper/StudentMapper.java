package com.qcs.student.mapper;

import com.qcs.student.pojo.Student;
import java.util.List;

/**
 *
 * @ClassName: StudentMapper
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface StudentMapper{

	/**
	 *
	 * @Title insertStudent
	 * @Description 向数据表student_info中插入一条Student记录
	 * @param student
	 * @return int
	 */
	public int insertStudent(Student student);

	/**
	 *
	 * @Title deleteStudent
	 * @Description 从数据表student_info中,根据传入参数做条件,删除一条Student记录
	 * @param student
	 * @return int
	 */
	public int deleteStudent(Student student);

	/**
	 *
	 * @Title updateStudent
	 * @Description 从数据表student_info中,根据Id,更新一条Student记录
	 * @param student
	 * @return int
	 */
	public int updateStudent(Student student);

	/**
	 *
	 * @Title nestedSelectStudent
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param student
	 * @return List<Student>
	 */
	public List<Student> nestedSelectStudent(Student student);

	/**
	 *
	 * @Title joinSelectStudent
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,采用连表查询的方式
	 * @param student
	 * @return List<Student>
	 */
	public List<Student> joinSelectStudent(Student student);

}