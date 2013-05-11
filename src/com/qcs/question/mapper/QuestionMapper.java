package com.qcs.question.mapper;

import com.qcs.question.pojo.Question;
import java.util.List;

/**
 *
 * @ClassName: QuestionMapper
 * @author 
 * @date 2013-05-11 06:00:07
 *
 */

public interface QuestionMapper{

	/**
	 *
	 * @Title insertQuestion
	 * @Description 向数据表question中插入一条Question记录
	 * @param question
	 * @return int
	 */
	public int insertQuestion(Question question);

	/**
	 *
	 * @Title deleteQuestion
	 * @Description 从数据表question中,根据传入参数做条件,删除一条Question记录
	 * @param question
	 * @return int
	 */
	public int deleteQuestion(Question question);

	/**
	 *
	 * @Title updateQuestion
	 * @Description 从数据表question中,根据Id,更新一条Question记录
	 * @param question
	 * @return int
	 */
	public int updateQuestion(Question question);

	/**
	 *
	 * @Title nestedSelectQuestion
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,复杂对象用子查询方式查询
	 * @param question
	 * @return List<Question>
	 */
	public List<Question> nestedSelectQuestion(Question question);

	/**
	 *
	 * @Title joinSelectQuestion
	 * @Description 根据传入的参数作为条件,从数据库查询出符合条件的记录,采用连表查询的方式
	 * @param question
	 * @return List<Question>
	 */
	public List<Question> joinSelectQuestion(Question question);

	public List<Question> queryNotChoose(Integer id);

}