package com.qcs.teacherManager.action;

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
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.teacher.pojo.Teacher;
import com.qcs.teacher.service.TeacherService;

@ParentPackage("struts-default")
@Namespace("/teacherManager")
@Results({
	@Result(name="list",location="/WEB-INF/pages/teacherManager/list.jsp"),
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class TeacherManagerAction extends BaseAction {
	public static String LIST = "list";
	
	private Logger log = Logger.getLogger(TeacherManagerAction.class);
	@Autowired
	private TeacherService teacherService;
	private Teacher teacher;
	private List<Teacher> teacherList;
	@Action("toQuery")
	public String toQuery(){
		return LIST;
	}
	@Action("query")
	public String query(){
		if(teacher == null){
			teacher = new Teacher();
		}
		if(!StringUtils.isNotBlank(teacher.getTeacherNo())){
			teacher.setTeacherNo(null);
		}
		if(!StringUtils.isNotBlank(teacher.getName())){
			teacher.setName(null);
		}
		try {
			teacherList = teacherService.query(teacher, false);
		} catch (BusinessException e) {
			log.info(e);
		}
		return LIST;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
}
