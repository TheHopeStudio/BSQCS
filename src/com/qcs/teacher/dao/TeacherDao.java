package com.qcs.teacher.dao;

import com.qcs.teacher.pojo.Teacher;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: TeacherDao
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public interface TeacherDao{

	/**
	 *
	 * @Title add
	 * @Description 根据Teacher的属性。往数据表teacher_info插入一条新记录
	 * @param teacher
	 * @return int
	 */
	public int add(Teacher teacher) throws DataAccessException;

	/**
	 *
	 * @Title delete
	 * @Description 根据Teacher的属性,删除数据表teacher_info一条记录
	 * @param teacher
	 * @return int
	 */
	public int delete(Teacher teacher) throws DataAccessException;

	/**
	 *
	 * @Title update
	 * @Description 根据Teacher的主键,更新数据表teacher_info一条记录
	 * @param teacher
	 * @return int
	 */
	public int update(Teacher teacher) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 根据参数teacher的属性做条件,查询数据表teacher_info的记录。
	 * 若join为true则采用表连接查询复杂属性.否则采用子查询方式查询
	 * @param teacher
	 * @param join
	 * @return List<Teacher>
	 */
	public List<Teacher> query(Teacher teacher,boolean join) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param teacher
	 * @param pageInfo
	 * @param join
	 * @return PaginationResult<Teacher>
	 */
	public PaginationResult<Teacher> query(Teacher teacher,PaginationInfo pageInfo,boolean join) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 根据参数teacher的属性做条件,查询数据表teacher_info的记录。采用嵌套查询方式查询复杂属性
	 * @param teacher
	 * @return List<Teacher>
	 */
	public List<Teacher> query(Teacher teacher) throws DataAccessException;

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param teacher
	 * @param pageInfo
	 * @return PaginationResult<Teacher>
	 */
	public PaginationResult<Teacher> query(Teacher teacher,PaginationInfo pageInfo) throws DataAccessException;

}