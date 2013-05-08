package com.qcs.base.servlet;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qcs.menu.pojo.Menu;
import com.qcs.menu.service.MenuService;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(loadOnStartup=31332132,description = "初始化Servlet", urlPatterns = { "/initServlet" })
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MenuService menuService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		ServletContext context = config.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
	    menuService = (MenuService) applicationContext.getBean("menuService");
		Menu menu = new Menu();
	    menu.setParentId("0");
	    menu.setType("2");
	    List<Menu> managerMenus = menuService.query(menu);
	    context.setAttribute("managerMenus", managerMenus);
	    menu.setType("1");
	    List<Menu> studentMenus = menuService.query(menu);
	    context.setAttribute("studentMenus", studentMenus);
	    menu.setType("0");
	    List<Menu> teacherMenus = menuService.query(menu);
	    context.setAttribute("teacherMenus", teacherMenus);
	}

}
