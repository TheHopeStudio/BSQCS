package com.qcs.base.Filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qcs.user.pojo.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	
	HashSet<String> accept;
    /**
     * Default constructor. 
     * @throws FileNotFoundException 
     */
    public LoginFilter(){
    	accept = new HashSet<String>();
    	try{
	    	BufferedReader br = new BufferedReader(new FileReader(this.getClass().getResource("/accept.acc").toString().substring(5)));
	    	String line = null;
	    	while((line = br.readLine()) != null){
	    		if(!line.startsWith("#")){
	    			accept.add(line);
	    		}
	    	}
	    	
    	}catch(IOException e){
    		//TODO change to log4j
    		e.printStackTrace();
    	}
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();
		String staticResourceReg = "^/QCS/((css)|(img)|(js))/.*";
		
		//不是静态文件
		if(!uri.matches(staticResourceReg)){
			//除允许访问页面外。未登陆跳转到index页面
			if(!this.accept.contains(uri)){
				User user = (User) session.getAttribute("login_user");
				if(null == user || null == user.getId()){
					response.sendRedirect(request.getContextPath()+"/login.jsp");
					return;
				}
			}
		}
		request.setAttribute("uri", uri);
		chain.doFilter(request, response);
	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
