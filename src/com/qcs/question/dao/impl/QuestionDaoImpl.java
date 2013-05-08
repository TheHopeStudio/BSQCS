package com.qcs.question.dao.impl;

import com.qcs.question.dao.QuestionDao;
import com.qcs.question.mapper.QuestionMapper;
import com.qcs.question.pojo.Question;
import java.util.List;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationContext;

/**
 *
 * @ClassName: QuestionDaoImpl
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class QuestionDaoImpl implements QuestionDao{
	/**
	*	Question映射的mapper
	*/
	private QuestionMapper questionMapper;

	/**
	 *
	 * @Title add
	 * @Description 根据Question的属性。往数据表question插入一条新记录
	 * @param question
	 * @return int
	 */
	public int add(Question question){

		return questionMapper.insertQuestion(question);

	}
	/**
	 *
	 * @Title delete
	 * @Description 根据Question的属性,删除数据表question一条记录
	 * @param question
	 * @return int
	 */
	public int delete(Question question){

		return questionMapper.deleteQuestion(question);

	}
	/**
	 *
	 * @Title update
	 * @Description 根据Question的主键,更新数据表question一条记录
	 * @param question
	 * @return int
	 */
	public int update(Question question){

		return questionMapper.updateQuestion(question);

	}
	/**
	 *
	 * @Title query
	 * @Description 根据参数question的属性做条件,查询数据表question的记录。
	 * @param question
	 * @return List<Question>
	 */
	public List<Question> query(Question question){

		return questionMapper.nestedSelectQuestion(question);

	}
	/**
	 *
	 * @Title query
	 * @Description 此方法是分页查询方法。根据pageInfo中的参数!查询数据表
	 * @param question
	 * @param pageInfo
	 * @return PaginationResult<Question>
	 */
	public PaginationResult<Question> query(Question question,PaginationInfo pageInfo){

		PaginationContext.set(pageInfo);
		PaginationResult<Question> pageResult = new PaginationResult<Question>();
		pageResult.setData(query(question));
		pageResult.setPaginationInfo(pageInfo);
		return pageResult;

	}
	/**
	 *
	 * @Title getQuestionMapper
	 * @Description 返回questionMapper的值
	 * @return QuestionMapper
	 */
	public QuestionMapper getQuestionMapper(){

		return this.questionMapper;

	}
	/**
	 *
	 * @Title setQuestionMapper
	 * @Description 设置questionMapper的值
	 * @param questionMapper
	 * @return void
	 */
	public void setQuestionMapper(QuestionMapper questionMapper){

		this.questionMapper = questionMapper;

	}
}