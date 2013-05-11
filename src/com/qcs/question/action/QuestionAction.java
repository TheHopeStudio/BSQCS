package com.qcs.question.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.qcs.question.pojo.ChoosingTime;
import com.qcs.question.pojo.Question;
import com.qcs.question.pojo.StudentQuestion;
import com.qcs.question.service.ChoosingTimeService;
import com.qcs.question.service.QuestionService;
import com.qcs.question.service.StudentQuestionService;
import com.qcs.student.pojo.Student;
import com.qcs.student.service.StudentService;
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
	@Result(name="auditList",location="/WEB-INF/pages/question/auditList.jsp"),
	@Result(name="choosingTime",location="/WEB-INF/pages/question/choosingTime.jsp"),
	@Result(name="studentList",location="/WEB-INF/pages/studentManager/list.jsp"),
	@Result(name="confirmStudentList",location="/WEB-INF/pages/question/confirmStudentList.jsp"),
	@Result(name="toExportResult",location="/WEB-INF/pages/question/exportResult.jsp"),
	@Result(name="exportResult",location="/WEB-INF/pages/question/resultExcel.jsp"),
	@Result(name="index",location="/user/index.do",type="redirect")
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class QuestionAction extends BaseAction {
	
	public static String NEW_QUESTION = "newQuestion";
	public static String QUESTION_LIST = "questionList";
	public static String UPDATE_SUCCESS = "updateSuccess";
	public static String AUDIT_LIST = "auditList";
	public static String CHOOSING_TIME = "choosingTime";
	public static String STUDENT_LIST = "studentList";
	public static String CONFIRM_STUDENT_LIST = "confirmStudentList";
	public static String TO_EXPORT_RESULT = "toExportResult";
	public static String EXPORT_RESULT = "exportResult";
	
	
	private String id;
	private String title;
	private String remark;
	private String content;
	private String state;
	
	private String name;
	private String startTime;
	private String endTime;
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private JobService jobService;
	@Autowired
	private ChoosingTimeService choosingTimeService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentQuestionService studentQuestionService;
	
	private Logger log = Logger.getLogger(QuestionAction.class);
	
	private List<Question> questionList;
	
	private List<ChoosingTime> choosingTimeList;
	
	private List<Student> studentList;
	
	@Action("toExportResult")
	public String toExportResult(){
		return TO_EXPORT_RESULT;
	}
	@Action("exportResult")
	public String exportResult(){
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Question question = new Question();
		if(StringUtils.isNotBlank(startTime)){
			try {
				question.setStartTime(smf.parse(startTime));
			} catch (ParseException e) {
				log.info(e);
				err = "开始时间格式不正确,必须为yyyy-MM-dd格式";
			}
		}
		if(StringUtils.isNotBlank(endTime)){
			try {
				//截至时间到下一天
				question.setEndTime(new Date(smf.parse(endTime).getTime()+24l*3600000l));
				
			} catch (ParseException e) {
				log.info(e);
				err = "结束时间格式不正确,必须为yyyy-MM-dd格式";
			}
		}
		if(err == null){
			try {
				questionList = questionService.query(question);
			} catch (BusinessException e) {
				log.debug(e);
				err = "查询数据出错!";
			}
		}
		return EXPORT_RESULT;
	}
	
	@Action("chooseQuestion")
	public String chooseQuestion() throws BusinessException{
		User user = (User) session.getAttribute("login_user");
		if(StringUtils.isNotBlank(id)){
			if(id.matches("\\d+")){
				Student stu = new Student();
				stu.setUserId(user.getId());
				try {
					stu = studentService.query(stu).get(0);
				} catch (BusinessException e) {
					log.debug(e);
				}
				StudentQuestion sq = new StudentQuestion();
				sq.setQuestionId(Integer.parseInt(id));
				sq.setStudentId(stu.getId());
				
				studentQuestionService.add(sq);
			}
		}
		return "index";
	}
	
	@Action("queryResult")
	public String queryResult(){
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Question question = new Question();
		if(StringUtils.isNotBlank(startTime)){
			try {
				question.setStartTime(smf.parse(startTime));
			} catch (ParseException e) {
				log.info(e);
				err = "开始时间格式不正确,必须为yyyy-MM-dd格式";
			}
		}
		if(StringUtils.isNotBlank(endTime)){
			try {
				//截至时间到下一天
				question.setEndTime(new Date(smf.parse(endTime).getTime()+24l*3600000l));
				
			} catch (ParseException e) {
				log.info(e);
				err = "结束时间格式不正确,必须为yyyy-MM-dd格式";
			}
		}
		if(err == null){
			try {
				questionList = questionService.query(question);
			} catch (BusinessException e) {
				log.debug(e);
				err = "查询数据出错!";
			}
		}
		
		return TO_EXPORT_RESULT;
	}
	
	@Action("confirmToStudent")
	public String confirmToStudent() throws BusinessException{
		if(StringUtils.isNotBlank(id)){
			int studentId = Integer.parseInt(id);
			String confirmId = (String) session.getAttribute("confirmQuestionId");
			session.removeAttribute("confirmQuestoinId");
			int questionId = Integer.parseInt(confirmId);
			Question question = new Question();
			question.setId(questionId);
			question.setStudentId(studentId);
			question.setLive(false);
			question.setChooseTime(new Date());
			questionService.update(question);
		}
		
		
		return SUCCESS;
	}
	
	@Action("confirm")
	public String confirm() throws BusinessException{
		if(StringUtils.isNotBlank(id)){
			session.setAttribute("confirmQuestionId", id);
		}
		studentList = studentService.queryStudentWhichNoQuestion();
		return CONFIRM_STUDENT_LIST;
	}
	
	@Action("showSelectionStudent")
	public String showSelectionStudent() throws BusinessException{
		if(StringUtils.isNotBlank(id)){
			Question question = new Question();
			question.setId(Integer.parseInt(id));
			questionList = questionService.query(question,true);
			if(questionList != null && questionList.size()>0){
				question = questionList.get(0);
			}
			studentList = question.getSelectionStudents();
		}
		
		return STUDENT_LIST;
	}
	
	
	
	
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
					questionList = questionService.query(question);
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

	@Action("choosingTime")
	public String choosingTime(){
		
		try {
			choosingTimeList = choosingTimeService.query(new ChoosingTime());
		} catch (BusinessException e) {
			e.printStackTrace();
			err = "查询数据失败";
		}
		
		return CHOOSING_TIME;
	}
	
	@Action("addChoosingTime")
	public String addChoosingTime() throws ParseException{
		if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(startTime)
				&& StringUtils.isNotBlank(endTime)){
			ChoosingTime choosingTime = new ChoosingTime();
			choosingTime.setName(name);
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
			choosingTime.setStartTime(smf.parse(startTime));
			choosingTime.setEndTime(smf.parse(endTime));
			choosingTime.setState("1");
			try {
				choosingTimeService.add(choosingTime);
			} catch (BusinessException e) {
				log.debug(e);
				err = "添加失败";
			}
		}
		return choosingTime();
	}
	
	public String deleteChoosingTime(){
		if(StringUtils.isNotBlank(id)){
			ChoosingTime choosingTime = new ChoosingTime();
			choosingTime.setId(Integer.parseInt(id));
			try {
				choosingTimeService.delete(choosingTime);
			} catch (BusinessException e) {
				log.debug(e);
				err = "删除失败";
			}
		}
		return choosingTime();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<ChoosingTime> getChoosingTimeList() {
		return choosingTimeList;
	}

	public void setChoosingTimeList(List<ChoosingTime> choosingTimeList) {
		this.choosingTimeList = choosingTimeList;
	}

	public ChoosingTimeService getChoosingTimeService() {
		return choosingTimeService;
	}

	public void setChoosingTimeService(ChoosingTimeService choosingTimeService) {
		this.choosingTimeService = choosingTimeService;
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
	public StudentQuestionService getStudentQuestionService() {
		return studentQuestionService;
	}
	public void setStudentQuestionService(
			StudentQuestionService studentQuestionService) {
		this.studentQuestionService = studentQuestionService;
	}
	
}
