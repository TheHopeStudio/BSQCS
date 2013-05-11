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
import com.qcs.job.pojo.Job;
import com.qcs.job.service.JobService;
import com.qcs.teacher.pojo.Teacher;
import com.qcs.teacher.service.TeacherService;

@ParentPackage("struts-default")
@Namespace("/teacherManager")
@Results({
	@Result(name="list",location="/WEB-INF/pages/teacherManager/list.jsp"),
	@Result(name="jobList",location="/WEB-INF/pages/teacherManager/jobList.jsp"),
	@Result(name="queryJob",location="/teacherManager/queryJob.do",type="redirect")
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class TeacherManagerAction extends BaseAction {
	public static String LIST = "list";
	public static String JOB_LIST = "jobList";
	public static String QUERY_JOB = "queryJob";
	
	private Logger log = Logger.getLogger(TeacherManagerAction.class);
	//各种service
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private JobService jobService;

	private Teacher teacher;
	private List<Teacher> teacherList;
	private List<Job> jobList;
	
	//向前台传递信息用的
	private String info;
	private String err;
	
	//接收job的参数
	private String job;
	private String questionNum;
	private String id;
	
	@Action("query")
	public String query(){
		try {
			teacherList = teacherService.query(teacher, false);
		} catch (BusinessException e) {
			log.info(e);
		}
		return LIST;
	}

	@Action("updateJob")
	public String updateJob(){
		Job tem = null;
		try{
			if(StringUtils.isNotBlank(id)){
				tem = new Job();
				if(id.matches("\\d+")){
					tem.setId(Integer.parseInt(id));
					tem.setJob(job);
					if(questionNum.matches("\\d+"))
						tem.setQuestionNum(Integer.parseInt(questionNum));
					jobService.update(tem);
				}
			}
		}catch(BusinessException e){
			log.debug(e);
		}
		
		return QUERY_JOB;
	}
	
	@Action("deleteJob")
	public String deleteJob(){
		try{
			if(StringUtils.isNotBlank(id)){
				Job tem = new Job();
				if(id.matches("\\d+")){
					tem.setId(Integer.parseInt(id));
					jobService.delete(tem);
				}
			}
		}catch(BusinessException e){
			log.debug(e);
			err = "删除失败";
		}
		if(null == err){
			info = "删除成功";
		}
		return QUERY_JOB;
	}
	
	@Action("addJob")
	public String addJob(){
		Job tem = null;
		try {
			if(StringUtils.isNotBlank(job) || StringUtils.isNotBlank(questionNum)){
				tem = new Job();
			}
			if(null != tem){
				tem.setJob(job);
				if(questionNum.matches("\\d+")){
					tem.setQuestionNum(Integer.parseInt(questionNum));
					jobService.add(tem);
				}
			}
		} catch (BusinessException e) {
			log.debug(e);
			err = "添加失败";
		}
		if(null == err){
			info = "添加成功";
		}
		return QUERY_JOB;
	}
	
	@Action("queryJob")
	public String queryJob(){
		try {
			jobList = jobService.query(new Job());
		} catch (BusinessException e) {
			log.debug(e);
		}
		return JOB_LIST;
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
	public JobService getJobService() {
		return jobService;
	}
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(String questionNum) {
		this.questionNum = questionNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
