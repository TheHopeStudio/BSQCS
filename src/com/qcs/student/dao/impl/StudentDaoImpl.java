package com.qcs.student.dao.impl;

import com.qcs.student.dao.StudentDao;
import com.qcs.student.mapper.StudentMapper;
import com.qcs.student.pojo.Student;
import java.util.List;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: StudentDaoImpl
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class StudentDaoImpl implements StudentDao{
	/**
	*	Student映射的mapper
	*/
	private StudentMapper studentMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据Student的属性。往数据表student_info插入一条新记录
	 * @param student
	 * @return int
	 */
	public int add(Student student){

		return studentMapper.insertStudent(student);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据Student的属性,删除数据表student_info一条记录
	 * @param student
	 * @return int
	 */
	public int delete(Student student){

		return studentMapper.deleteStudent(student);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据Student的主键,更新数据表student_info一条记录
	 * @param student
	 * @return int
	 */
	public int update(Student student){

		return studentMapper.updateStudent(student);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数student的属性做条件,查询数据表student_info的记录。
	 * 若join为true则采用表连接查询复杂属性.否则采用子查询方式查询
	 * @param student
	 * @param join
	 * @return List<Student>
	 */
	public List<Student> query(Student student,boolean join){

		if(join){
			return studentMapper.joinSelectStudent(student);
		}else{
			return studentMapper.nestedSelectStudent(student);
		}

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param student
	 * @param pageInfo
	 * @param join
	 * @return PaginationResult<Student>
	 */
	public PaginationResult<Student> query(Student student,PaginationInfo pageInfo,boolean join){

		PaginationContext.set(pageInfo);
		PaginationResult<Student> pageResult = new PaginationResult<Student>();
		pageResult.setData(query(student,join));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数student的属性做条件,查询数据表student_info的记录。采用嵌套查询方式查询复杂属性
	 * @param student
	 * @return List<Student>
	 */
	public List<Student> query(Student student){

		return query(student,false);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param student
	 * @param pageInfo
	 * @return PaginationResult<Student>
	 */
	public PaginationResult<Student> query(Student student,PaginationInfo pageInfo){

		PaginationContext.set(pageInfo);
		PaginationResult<Student> pageResult = new PaginationResult<Student>();
		pageResult.setData(query(student));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getStudentMapper
	 * @Description 返回studentMapper的值
	 * @return StudentMapper
	 */
	public StudentMapper getStudentMapper(){

		return this.studentMapper;

	}
	/**
	 *
	 * @Title setStudentMapper
	 * @Description 设置studentMapper的值
	 * @param studentMapper
	 * @return void
	 */
	public void setStudentMapper(StudentMapper studentMapper){

		this.studentMapper = studentMapper;

	}
}