package com.qcs.user.pojo;


/**
 *
 * @ClassName: User
 * @author 
 * @date 2013-05-05 03:45:51
 *
 */

public class User{
	private Integer id;
	/**
	*	用户名
	*/
	private String username;
	/**
	*	密码
	*/
	private String password;
	/**
	*	状态
0：正常
1：冻结
	*/
	private String state;
	/**
	*	类型
0：教师
1：学生
2：管理员
	*/
	private String type;

	/**
	 *
	 * @Title getId
	 * @Description 返回id的值
	 * @return Integer
	 */
	public Integer getId(){

		return this.id;

	}
	/**
	 *
	 * @Title setId
	 * @Description 设置id的值
	 * @param id
	 * @return void
	 */
	public void setId(Integer id){

		this.id = id;

	}
	/**
	 *
	 * @Title getUsername
	 * @Description 返回username的值
	 * @return String
	 */
	public String getUsername(){

		return this.username;

	}
	/**
	 *
	 * @Title setUsername
	 * @Description 设置username的值
	 * @param username
	 * @return void
	 */
	public void setUsername(String username){

		this.username = username;

	}
	/**
	 *
	 * @Title getPassword
	 * @Description 返回password的值
	 * @return String
	 */
	public String getPassword(){

		return this.password;

	}
	/**
	 *
	 * @Title setPassword
	 * @Description 设置password的值
	 * @param password
	 * @return void
	 */
	public void setPassword(String password){

		this.password = password;

	}
	/**
	 *
	 * @Title getState
	 * @Description 返回state的值
	 * @return String
	 */
	public String getState(){

		return this.state;

	}
	/**
	 *
	 * @Title setState
	 * @Description 设置state的值
	 * @param state
	 * @return void
	 */
	public void setState(String state){

		this.state = state;

	}
	/**
	 *
	 * @Title getType
	 * @Description 返回type的值
	 * @return String
	 */
	public String getType(){

		return this.type;

	}
	/**
	 *
	 * @Title setType
	 * @Description 设置type的值
	 * @param type
	 * @return void
	 */
	public void setType(String type){

		this.type = type;

	}
}