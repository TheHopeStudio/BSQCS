package com.qcs.teacher.dao.impl;

import com.qcs.teacher.dao.TeacherDao;
import com.qcs.teacher.mapper.TeacherMapper;
import com.qcs.teacher.pojo.Teacher;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: TeacherDaoImpl
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */
@Repository
public class TeacherDaoImpl implements TeacherDao{
	/**
	*	Teacher映射的mapper
	*/
	private TeacherMapper teacherMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据Teacher的属性。往数据表teacher_info插入一条新记录
	 * @param teacher
	 * @return int
	 */
	public int add(Teacher teacher) throws DataAccessException{

		return teacherMapper.insertTeacher(teacher);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据Teacher的属性,删除数据表teacher_info一条记录
	 * @param teacher
	 * @return int
	 */
	public int delete(Teacher teacher) throws DataAccessException{

		return teacherMapper.deleteTeacher(teacher);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据Teacher的主键,更新数据表teacher_info一条记录
	 * @param teacher
	 * @return int
	 */
	public int update(Teacher teacher) throws DataAccessException{

		return teacherMapper.updateTeacher(teacher);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数teacher的属性做条件,查询数据表teacher_info的记录。
	 * 若join为true则采用表连接查询复杂属性.否则采用子查询方式查询
	 * @param teacher
	 * @param join
	 * @return List<Teacher>
	 */
	public List<Teacher> query(Teacher teacher,boolean join) throws DataAccessException{

		if(join){
			return teacherMapper.joinSelectTeacher(teacher);
		}else{
			return teacherMapper.nestedSelectTeacher(teacher);
		}

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param teacher
	 * @param pageInfo
	 * @param join
	 * @return PaginationResult<Teacher>
	 */
	public PaginationResult<Teacher> query(Teacher teacher,PaginationInfo pageInfo,boolean join) throws DataAccessException{

		PaginationContext.set(pageInfo);
		PaginationResult<Teacher> pageResult = new PaginationResult<Teacher>();
		pageResult.setData(query(teacher,join));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数teacher的属性做条件,查询数据表teacher_info的记录。采用嵌套查询方式查询复杂属性
	 * @param teacher
	 * @return List<Teacher>
	 */
	public List<Teacher> query(Teacher teacher) throws DataAccessException{

		return query(teacher,false);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param teacher
	 * @param pageInfo
	 * @return PaginationResult<Teacher>
	 */
	public PaginationResult<Teacher> query(Teacher teacher,PaginationInfo pageInfo) throws DataAccessException{

		PaginationContext.set(pageInfo);
		PaginationResult<Teacher> pageResult = new PaginationResult<Teacher>();
		pageResult.setData(query(teacher));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getTeacherMapper
	 * @Description 返回teacherMapper的值
	 * @return TeacherMapper
	 */
	public TeacherMapper getTeacherMapper(){

		return this.teacherMapper;

	}
	/**
	 *
	 * @Title setTeacherMapper
	 * @Description 设置teacherMapper的值
	 * @param teacherMapper
	 * @return void
	 */
	public void setTeacherMapper(TeacherMapper teacherMapper){

		this.teacherMapper = teacherMapper;

	}
}