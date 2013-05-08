package com.qcs.user.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.qcs.base.action.BaseAction;
import com.qcs.user.pojo.User;
import com.qcs.user.service.UserService;

@ParentPackage("struts-default")
@Namespace("/user")
@Results({
	@Result(name="success",location="/user/index.do",type="redirect"),
	@Result(name="loginFail",location="/WEB-INF/pages/login.jsp"),
	@Result(name="registFail",location="/WEB-INF/pages/register.jsp"),
	@Result(name="login",location="/WEB-INF/pages/login.jsp"),
	@Result(name="index",location="/WEB-INF/pages/index.jsp")
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class UserAction extends BaseAction {

	/** 
	 * @Fields serialVersionUID : 
	 */ 
	private static final long serialVersionUID = 9091488430275094097L;
	
	private static String LOGIN_FAIL = "loginFail";
	private static String REGIST_FAIL = "registFail";
	private static String INDEX = "index";
	
	private String username;
	private String password;
	private User user;
	
	@Autowired
	private UserService userService;
	
	@Action("index")
	public String toIndex(){
		return INDEX;
	}
	
	@Action("logout")
	public String logout(){
		User loginedUser = (User) session.getAttribute("login_user");
		if(loginedUser != null){
			session.setAttribute("login_user", null);
		}
		return LOGIN;
	}
	
	@Action("login")
	public String login(){
		//检查是否已经登陆过
		User loginedUser = (User) session.getAttribute("login_user");
		if(loginedUser != null){
			return SUCCESS;
		}
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
		}
		if(user != null){
			if(StringUtils.isNotBlank(user.getUsername())
					&& StringUtils.isNotBlank(user.getPassword())){
				user = userService.login(user);
				if(user != null){
					session.setAttribute("login_user", user);
					return SUCCESS;
				}
			}
		}
		request.setAttribute("err", "用户名或密码错误!");
		return LOGIN_FAIL;
	}
	
	@Action("regist")
	public String register(){
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
		}
		if(user != null){
			if(StringUtils.isNotBlank(user.getUsername())
					&& StringUtils.isNotBlank(user.getPassword())){
				user = userService.createManager(user);
				if(user != null){
					session.setAttribute("login_user", user);
					return SUCCESS;
				}
			}
		}
		request.setAttribute("err", "注册失败");
		return REGIST_FAIL;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
