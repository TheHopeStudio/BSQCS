package com.qcs.teacher.mapper;

import com.qcs.teacher.pojo.Teacher;
import java.util.List;

/**
 *
 * @ClassName: TeacherMapper
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface TeacherMapper{

	/**
	 *
	 * @Title insertTeacher
	 * @Description 向数据表teacher_info中插入一条Teacher记录
	 * @param teacher
	 * @return int
	 */
	public int insertTeacher(Teacher teacher);

	/**
	 *
	 * @Title deleteTeacher
	 * @Description 从数据表teacher_info中,根据传入参数做条件,删除一条Teacher记录
	 * @param teacher
	 * @return int
	 */
	public int deleteTeacher(Teacher teacher);

	/**
	 *
	 * @Title updateTeacher
	 * @Description 从数据表teacher_info中,根据Id,更新一条Teacher记录
	 * @param teacher
	 * @return int
	 */
	public int updateTeacher(Teacher teacher);

	/**
	 *
	 * @Title nestedSelectTeacher
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param teacher
	 * @return List<Teacher>
	 */
	public List<Teacher> nestedSelectTeacher(Teacher teacher);

	/**
	 *
	 * @Title joinSelectTeacher
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,采用连表查询的方式
	 * @param teacher
	 * @return List<Teacher>
	 */
	public List<Teacher> joinSelectTeacher(Teacher teacher);

}