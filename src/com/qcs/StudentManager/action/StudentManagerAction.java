package com.qcs.StudentManager.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
import com.qcs.question.service.QuestionService;
import com.qcs.student.pojo.Student;
import com.qcs.student.service.StudentService;
import com.qcs.user.pojo.User;
import com.qcs.user.service.UserService;

@ParentPackage("struts-default")
@Namespace("/studentManager")
@Results({
	@Result(name="list",location="/WEB-INF/pages/studentManager/list.jsp"),
	@Result(name="toStudentList",location="/studentManager/studentList.do",type="redirect")
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 

public class StudentManagerAction extends BaseAction {

	private static String LIST = "list";
	private static String TO_STUDENT_LIST = "toStudentList";
	
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private UserService userService;
	
	private List<Student> studentList;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private String id;
	
	@Action("freeze")
	public String freeze(){
		if(StringUtils.isNotBlank(id)){
			User user = new User();
			user.setId(Integer.parseInt(id));
			userService.freeze(user);
		}
		return TO_STUDENT_LIST;
	}
	@Action("delete")
	public String delete() throws BusinessException{
		if(StringUtils.isNotBlank(id)){
			//数据库必须设计成级联删除
			User user = new User();
			user.setId(Integer.parseInt(id));
			userService.delete(user);
		}
		return TO_STUDENT_LIST;
	}
	
	@Action("unFreeze")
	public String unFreeze(){
		if(StringUtils.isNotBlank(id)){
			User user = new User();
			user.setId(Integer.parseInt(id));
			userService.unFreeze(user);
		}
		return TO_STUDENT_LIST;
	}
	
	
	
	@Action("studentList")
	public String studentList(){
		
		try {
			studentList = studentService.query(new Student(),true);
		} catch (BusinessException e) {
			log.debug(e);
			err = "查询数据失败";
		}
		
		return LIST;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public static String getTO_STUDENT_LIST() {
		return TO_STUDENT_LIST;
	}
	public static void setTO_STUDENT_LIST(String tO_STUDENT_LIST) {
		TO_STUDENT_LIST = tO_STUDENT_LIST;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
