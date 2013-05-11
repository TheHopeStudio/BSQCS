package com.qcs.question.dao;

import com.qcs.question.pojo.Question;
import java.util.List;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: QuestionDao
 * @author 
 * @date 2013-05-09 09:46:25
 *
 */

public interface QuestionDao{

	/**
	 *
	 * @Title add
	 * @Description 根据Question的属性。往数据表question插入一条新记录
	 * @param question
	 * @return int
	 */
	public int add(Question question);

	/**
	 *
	 * @Title delete
	 * @Description 根据Question的属性,删除数据表question一条记录
	 * @param question
	 * @return int
	 */
	public int delete(Question question);

	/**
	 *
	 * @Title update
	 * @Description 根据Question的主键,更新数据表question一条记录
	 * @param question
	 * @return int
	 */
	public int update(Question question);

	/**
	 *
	 * @Title query
	 * @Description 根据参数question的属性做条件,查询数据表question的记录。
	 * 若join为true则采用表连接查询复杂属性.否则采用子查询方式查询
	 * @param question
	 * @param join
	 * @return List<Question>
	 */
	public List<Question> query(Question question,boolean join);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param question
	 * @param pageInfo
	 * @param join
	 * @return PaginationResult<Question>
	 */
	public PaginationResult<Question> query(Question question,PaginationInfo pageInfo,boolean join);

	/**
	 *
	 * @Title query
	 * @Description 根据参数question的属性做条件,查询数据表question的记录。采用嵌套查询方式查询复杂属性
	 * @param question
	 * @return List<Question>
	 */
	public List<Question> query(Question question);

	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param question
	 * @param pageInfo
	 * @return PaginationResult<Question>
	 */
	public PaginationResult<Question> query(Question question,PaginationInfo pageInfo);

	public List<Question> queryNotChoose(Integer id);

}