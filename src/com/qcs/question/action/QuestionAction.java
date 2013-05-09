package com.qcs.question.action;

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
import com.qcs.question.pojo.Question;
import com.qcs.question.service.QuestionService;
import com.qcs.teacher.pojo.Teacher;
import com.qcs.teacher.service.TeacherService;
import com.qcs.user.pojo.User;

@ParentPackage("struts-default")
@Namespace("/question")
@Results({
	@Result(name="newQuestion",location="/WEB-INF/pages/question/newQuestion.jsp"),
	@Result(name="questionList",location="/WEB-INF/pages/question/questionList.jsp"),
	@Result(name="updateSuccess",location="/WEB-INF/pages/question/updateQuestion.jsp"),
	@Result(name="success",location="/question/myQuestion.do",type="redirect"),
	@Result(name="auditList",location="/WEB-INF/pages/question/auditList.jsp")
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class QuestionAction extends BaseAction {
	
	public static String NEW_QUESTION = "newQuestion";
	public static String QUESTION_LIST = "questionList";
	public static String UPDATE_SUCCESS = "updateSuccess";
	public static String AUDIT_LIST = "auditList";
	
	private String id;
	private String title;
	private String remark;
	private String content;
	private String state;
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private JobService jobService;
	
	private Logger log = Logger.getLogger(QuestionAction.class);
	
	private List<Question> questionList;
	
	/**
	 * 
	 * @Title	toAudit 
	 * @Description	去审批页面
	 * @return String
	 */
	@Action("toAudit")
	public String toAudit(){
		try{
			Question tem = new Question();
			tem.setState("0");
			tem.setLive(true);
			questionList = questionService.query(tem);
			
		}catch(BusinessException e){
			log.debug(e);
		}
		return AUDIT_LIST;
	}
	
	@Action("auditQuestion")
	public String auditQuestion(){
		try{
			if(StringUtils.isNotBlank(id) && StringUtils.isNotBlank(state)){
				if(id.matches("\\d+")){
					Question tem = new Question();
					tem.setId(Integer.parseInt(id));
					tem.setState(state);
					questionService.update(tem);
					setInfo("审核成功");
					return toAudit();
				}
			}
		}catch(BusinessException e){
			log.debug(e);
			setErr("审核失败");
		}
		return AUDIT_LIST;
	}
	/**
	 * 
	 * @Title	myQuestion 
	 * @Description	教师查看自己的出题
	 * @return String
	 */
	@Action("myQuestion")
	public String myQuestion(){
		try{
			User loginUser = (User) session.getAttribute("login_user");
			if(loginUser.getType().equals("0")){
				//获得教师资料
				Teacher teacher = new Teacher();
				teacher.setUserId(loginUser.getId());
				List<Teacher> teacherList = teacherService.query(teacher);
				if(teacherList != null && teacherList.size()>0){
					teacher = teacherList.get(0);
					Question question = new Question();
					question.setTeacherId(teacher.getId());
					questionList = questionService.query(question,true);
				}
			}
		}catch(BusinessException e){
			log.debug(e);
		}
		return QUESTION_LIST;
	}
	
	/**
	 * 
	 * @Title	newQuestion 
	 * @Description	到出题页面
	 * @return String
	 */
	@Action("newQuestion")
	public String newQuestion(){
		return NEW_QUESTION;
	}
	
	/**
	 * 
	 * @Title	deleteQuestion 
	 * @Description	删掉一个题目
	 * @return String
	 */
	@Action("deleteQuestion")
	public String deleteQuestion(){
		try{
			if(StringUtils.isNotBlank(id) && id.matches("\\d+")){
				Question tem = new Question();
				tem.setId(Integer.parseInt(id));
				questionService.delete(tem);
				setInfo("删除成功");
			}
		}catch(BusinessException e){
			log.debug(e);
			setErr("删除失败");
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title	toUpdateQuestion 
	 * @Description	到修改页面
	 * @return String
	 */
	@Action("toUpdateQuestion")
	public String toUpdateQuestion(){
		try{
			if(StringUtils.isNotBlank(id) && id.matches("\\d+")){
				Question tem = new Question();
				tem.setId(Integer.parseInt(id));
				questionList = questionService.query(tem);
				tem = questionList.get(0);
				id = tem.getId().toString();
				title = tem.getTitle();
				remark = tem.getRemark();
				content = tem.getContent();
			}
			
		}catch(BusinessException e){
			log.debug(e);
			
		}
		return UPDATE_SUCCESS;
	}
	
	/**
	 * 
	 * @Title	updateQuestion 
	 * @Description	修改一个题目
	 * @return String
	 */
	@Action("updateQuestion")
	public String updateQuestion(){
		try{
			if(StringUtils.isNotBlank(id) && id.matches("\\d+")){
				Question tem = new Question();
				tem.setId(Integer.parseInt(id));
				tem.setTitle(title);
				tem.setRemark(remark);
				tem.setContent(content);
				questionService.update(tem);
				setInfo("更新成功");
			}
			
		}catch(BusinessException e){
			setErr("更新失败");
			log.debug(e);
			
		}
		return UPDATE_SUCCESS;
	}
	
	/**
	 * 
	 * @Title	addQuestion 
	 * @Description	添加一道题目
	 * @return String
	 */
	@Action("addQuestion")
	public String addQuestion(){
		try {
			User loginUser = (User) session.getAttribute("login_user");
			if(loginUser.getType().equals("0")){
				//获得教师资料
				Teacher teacher = new Teacher();
				teacher.setUserId(loginUser.getId());
				List<Teacher> teacherList = teacherService.query(teacher);
				if(teacherList != null && teacherList.size()>0){
					teacher = teacherList.get(0);
				}
				//查询教师可以出题的数量
				int questionNum = 0;
				Job job = new Job();
				job.setJob(teacher.getJob());
				List<Job> jobList = jobService.query(job);
				if(jobList != null && jobList.size()>0){
					job = jobList.get(0);
					questionNum = job.getQuestionNum();
				}
				
				Question tem = new Question();
				tem.setTeacherId(teacher.getId());
				tem.setLive(true);
				List<Question> list = questionService.query(tem);
				if(list != null && list.size() >= questionNum){
					err = "\""+teacher.getJob()+"\"只能出"+questionNum+"道题目,出题不成功！";
					return NEW_QUESTION;
				}else{
					Question question = new Question();
					question.setTeacherId(teacher.getId());
					question.setTitle(title);
					question.setRemark(remark);
					question.setContent(content);
					question.setState("0");//审核中
					question.setLive(true);
					questionService.add(question);
					info = "出题成功";
					title = remark = content = null;
					
					return NEW_QUESTION;
				}
			}
			
			
		} catch (BusinessException e) {
			log.debug(e);
		}
		
		return NEW_QUESTION;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
