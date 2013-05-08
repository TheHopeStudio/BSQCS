package com.qcs.question.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.qcs.base.action.BaseAction;
import com.qcs.question.service.QuestionService;

@ParentPackage("struts-default")
@Namespace("/question")
@Results({
	@Result(name="newQuestion",location="/WEB-INF/pages/question/newQuestion.jsp"),
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class QuestionAction extends BaseAction {
	public static String NEW_QUESTION = "newQuestion";
	
	private String title;
	private String remark;
	private String content;
	
	@Autowired
	private QuestionService questionService;
	
	@Action("newQuestion")
	public String newQuestion(){
		return NEW_QUESTION;
	}
	
	@Action("addQuestion")
	public String addQuestion(){
		
		return NEW_QUESTION;
	}
	
	
}
