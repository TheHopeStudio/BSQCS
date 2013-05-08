package com.qcs.menu.pojo;

import java.util.List;

/**
 *
 * @ClassName: Menu
 * @author 
 * @date 2013-05-05 09:27:17
 *
 */

public class Menu{
	private Integer id;
	/**
	*	父菜单id
	*/
	private String parentId;
	/**
	*	排序序列
	*/
	private String seq;
	/**
	*	标题
	*/
	private String title;
	/**
	*	uri

	*/
	private String uri;
	/**
	*	类型
0：教师
1：学生
2：管理员
	*/
	private String type;
	private List<Menu> subMenus;

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
	 * @Title getParentId
	 * @Description 返回parentId的值
	 * @return String
	 */
	public String getParentId(){

		return this.parentId;

	}
	/**
	 *
	 * @Title setParentId
	 * @Description 设置parentId的值
	 * @param parentId
	 * @return void
	 */
	public void setParentId(String parentId){

		this.parentId = parentId;

	}
	/**
	 *
	 * @Title getSeq
	 * @Description 返回seq的值
	 * @return String
	 */
	public String getSeq(){

		return this.seq;

	}
	/**
	 *
	 * @Title setSeq
	 * @Description 设置seq的值
	 * @param seq
	 * @return void
	 */
	public void setSeq(String seq){

		this.seq = seq;

	}
	/**
	 *
	 * @Title getTitle
	 * @Description 返回title的值
	 * @return String
	 */
	public String getTitle(){

		return this.title;

	}
	/**
	 *
	 * @Title setTitle
	 * @Description 设置title的值
	 * @param title
	 * @return void
	 */
	public void setTitle(String title){

		this.title = title;

	}
	/**
	 *
	 * @Title getUri
	 * @Description 返回uri的值
	 * @return String
	 */
	public String getUri(){

		return this.uri;

	}
	/**
	 *
	 * @Title setUri
	 * @Description 设置uri的值
	 * @param uri
	 * @return void
	 */
	public void setUri(String uri){

		this.uri = uri;

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
	/**
	 *
	 * @Title getSubMenus
	 * @Description 返回subMenus的值
	 * @return List<Menu>
	 */
	public List<Menu> getSubMenus(){

		return this.subMenus;

	}
	/**
	 *
	 * @Title setSubMenus
	 * @Description 设置subMenus的值
	 * @param subMenus
	 * @return void
	 */
	public void setSubMenus(List<Menu> subMenus){

		this.subMenus = subMenus;

	}
}