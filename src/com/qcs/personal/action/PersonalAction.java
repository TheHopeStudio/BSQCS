package com.qcs.personal.action;

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
import com.qcs.common.utils.MD5Utils;
import com.qcs.user.pojo.User;
import com.qcs.user.service.UserService;

@ParentPackage("struts-default")
@Namespace("/personal")
@Results({
	@Result(name="toModifyPassword",location="/WEB-INF/pages/personal/modifyPassword.jsp"),
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class PersonalAction extends BaseAction {
	public static String TO_MODIFY_PASSWORD = "toModifyPassword";
	
	private String username;
	private String password;
	private String password1;
	private String password2;
	@Autowired
	private UserService userService;
	
	@Action("modifyPassword")
	public String modifyPassword(){
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)
			&& StringUtils.isNotBlank(password1) && StringUtils.isNotBlank(password2)){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user = userService.login(user);
			if(user != null){
				if(password1.equals(password2)){
					User tem = new User();
					tem.setId(user.getId());
					tem.setPassword(MD5Utils.getMD5(password1.getBytes()));
					userService.update(tem);
					request.setAttribute("info", "密码修改成功");
				}else{
					request.setAttribute("err", "两次密码输入不一致");
				}
			}else{
				request.setAttribute("err", "密码错误");
			}
		}
		
		return TO_MODIFY_PASSWORD;
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

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
