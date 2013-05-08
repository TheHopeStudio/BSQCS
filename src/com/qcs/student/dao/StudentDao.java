package com.qcs.student.dao;

import com.qcs.student.pojo.Student;
import java.util.List;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: StudentDao
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface StudentDao{

	/**
	 *
	 * @Title add
	 * @Description 根据Student的属性。往数据表student_info插入一条新记录
	 * @param student
	 * @return int
	 */
	public int add(Student student);

	/**
	 *
	 * @Title delete
	 * @Description 根据Student的属性,删除数据表student_info一条记录
	 * @param student
	 * @return int
	 */
	public int delete(Student student);

	/**
	 *
	 * @Title update
	 * @Description 根据Student的主键,更新数据表student_info一条记录
	 * @param student
	 * @return int
	 */
	public int update(Student student);

	/**
	 *
	 * @Title query
	 * @Description 根据参数student的属性做条件,查询数据表student_info的记录。
	 * 若join为true则采用表连接查询复杂属性.否则采用子查询方式查询
	 * @param student
	 * @param join
	 * @return List<Student>
	 */
	public List<Student> query(Student student,boolean join);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param student
	 * @param pageInfo
	 * @param join
	 * @return PaginationResult<Student>
	 */
	public PaginationResult<Student> query(Student student,PaginationInfo pageInfo,boolean join);

	/**
	 *
	 * @Title query
	 * @Description 根据参数student的属性做条件,查询数据表student_info的记录。采用嵌套查询方式查询复杂属性
	 * @param student
	 * @return List<Student>
	 */
	public List<Student> query(Student student);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param student
	 * @param pageInfo
	 * @return PaginationResult<Student>
	 */
	public PaginationResult<Student> query(Student student,PaginationInfo pageInfo);

}