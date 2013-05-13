package com.qcs.question.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.qcs.base.action.BaseAction;
import com.qcs.base.exception.BusinessException;
import com.qcs.question.pojo.Question;
import com.qcs.question.pojo.StudentQuestion;
import com.qcs.question.service.QuestionService;
import com.qcs.question.service.StudentQuestionService;
import com.qcs.student.pojo.Student;
import com.qcs.student.service.StudentService;
@ParentPackage("struts-default")
@Namespace("/computeResult")
@Results({
	@Result(name="choosingTime",location="/question/choosingTime.do?info=compute result success!",type="redirect"),
	
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class ComputeResultAction extends BaseAction{
	
	public String CHOOSING_TIME ="choosingTime";
	
	@Autowired
	private StudentQuestionService studentQuestionService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private StudentService studentService;
	
	@Action("compute")
	public String compute(){
		int studentId = -1;
		int questionId = -1;
		try {
			List<StudentQuestion> incompleteChoose = studentQuestionService.queryInComplete();
			for(StudentQuestion sq : incompleteChoose){
				//上一次遍历过的学生。。（已经处理过。跳过）
				if(sq.getStudentId() == studentId){
					continue;
				}
				questionId = sq.getQuestionId();
				Question question = new Question();
				question.setId(questionId);
				question = questionService.query(question).get(0);
				if(question.getStudentId() == null){
					studentId = sq.getStudentId();
					question.setStudentId(studentId);
					question.setLive(false);
					int row =questionService.update(question);
				}
				
			}
		
			List<Student> studentList = studentService.queryStudentWhichNoQuestion();
			Question tem = new Question();
			tem.setLive(true);
			List<Question> questionList = questionService.query(tem);
			for(int i=0;i<studentList.size();++i){
				if(questionList.size() > i+1){
					//学生和题目都有
					Question question = questionList.get(i);
					question.setStudentId(studentList.get(i).getId());
					question.setLive(false);
					questionService.update(question);
				}else{
					//题目用完
					break;
				}
			}
			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return CHOOSING_TIME;
	}
}
